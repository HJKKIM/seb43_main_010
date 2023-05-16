import styled from 'styled-components';
import moonSvg from '../../../assets/svg-file/moon-verified-icon.svg';
import rmJpg from '../../../assets/jpg-file/artist-profile/rm-profile.jpg';

const NoticeArtContentLiBlock = styled.li`
  margin-top: 29px;
  width: 430px;
  max-height: 78px;

  .date {
    color: var(--light-gray-400);
    font-size: 13px;
    font-weight: 800;
    display: ${({ hide }) => (hide ? 'none' : 'block')};
  }

  .detail-content {
    display: flex;
    padding-top: 21px;

    .art-img {
      width: 44px;
      height: 44px;
      border-radius: 50%;
      background: no-repeat url(${rmJpg});
      background-size: 44px 44px;
    }
  }

  .art-txt {
    padding-left: 11px;
    width: 375px;
    font-size: 15px;
    color: var(--dark-blue-900);
    line-height: 20px;

    p {
      text-overflow: ellipsis;
      overflow: hidden;
      word-break: break-word;

      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }

    .art-name {
      font-weight: 800;
    }

    .moon-icon {
      width: 10px;
      margin: 0 4px 0 3px;
    }

    .des {
      font-weight: 500;
    }
    .real-content {
      font-weight: 500;
    }

    .mini-name-date {
      font-size: 12px;
      padding-top: 10px;

      .mini-name {
        color: var(--gray-600);
        font-weight: 600;
      }

      .mini-date {
        color: var(--light-gray-400);
        font-weight: 600;
      }

      .mini-circle {
        color: var(--light-gray-300);
        font-weight: 800;
        padding: 0 4px;
      }
    }
  }
`;

const NoticeArtContentAllLi = ({ groupName, hide }) => {
  return (
    <NoticeArtContentLiBlock hide={hide}>
      <div className='all-content'>
        <div className='date'>오늘</div>
        <div className='detail-content'>
          <div className='art-img'></div>
          <div className='art-txt'>
            <p>
              <span className='art-name'>남준</span>
              <img className='moon-icon' src={moonSvg} alt='moon' />
              <span className='des'>님이 포스트를 작성했습니다 : </span>
              <span className='real-content'>안녕하세요 여러분 오랜만입니다 무탈하신지요 저는 시시콜콜하게 그럭저럭 잘 지내고 있습니다</span>
            </p>
            <div className='mini-name-date'>
              <span className='mini-name'>{groupName}</span>
              <span className='mini-circle'>・</span>
              <span className='mini-date'>2023.05.15</span>
            </div>
          </div>
        </div>
      </div>
    </NoticeArtContentLiBlock>
  );
};

export default NoticeArtContentAllLi;
