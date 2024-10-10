package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractLoanTradingNotificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An underlying abstract structure for all syndicated loan servicing notifications; the wrapper for events which occur through the life-cycle of a loan trade.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanTradingNotification", builder=AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractLoanTradingNotification extends CorrectableRequestMessage {

	AbstractLoanTradingNotificationMeta metaData = new AbstractLoanTradingNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business date on which the notice is valid (and was communicated).
	 */
	Date getNoticeDate();
	/**
	 * The party sending the notification.
	 */
	PartyReference getPartyReference();
	/**
	 * The role of the party that is sending the notification.
	 */
	LoanTradingPartyRole getRole();

	/*********************** Build Methods  ***********************/
	AbstractLoanTradingNotification build();
	
	AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder toBuilder();
	
	static AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder builder() {
		return new AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTradingNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTradingNotification> getType() {
		return AbstractLoanTradingNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTradingNotificationBuilder extends AbstractLoanTradingNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder getOrCreateRole();
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder getRole();
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setPartyReference(PartyReference partyReference);
		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setRole(LoanTradingPartyRole role);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
		}
		

		AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTradingNotification  ***********************/
	class AbstractLoanTradingNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanTradingNotification {
		private final Date noticeDate;
		private final PartyReference partyReference;
		private final LoanTradingPartyRole role;
		
		protected AbstractLoanTradingNotificationImpl(AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder builder) {
			super(builder);
			this.noticeDate = builder.getNoticeDate();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noticeDate")
		public Date getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("role")
		public LoanTradingPartyRole getRole() {
			return role;
		}
		
		@Override
		public AbstractLoanTradingNotification build() {
			return this;
		}
		
		@Override
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder toBuilder() {
			AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNoticeDate()).ifPresent(builder::setNoticeDate);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradingNotification {" +
				"noticeDate=" + this.noticeDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanTradingNotification  ***********************/
	class AbstractLoanTradingNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
	
		protected Date noticeDate;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected LoanTradingPartyRole.LoanTradingPartyRoleBuilder role;
	
		public AbstractLoanTradingNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("noticeDate")
		public Date getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("role")
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder getOrCreateRole() {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = LoanTradingPartyRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanTradingNotification build() {
			return new AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl(this);
		}
		
		@Override
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder prune() {
			super.prune();
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNoticeDate()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder o = (AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			merger.mergeBasic(getNoticeDate(), o.getNoticeDate(), this::setNoticeDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradingNotificationBuilder {" +
				"noticeDate=" + this.noticeDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}' + " " + super.toString();
		}
	}
}
