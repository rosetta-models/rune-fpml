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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.LoanNotificationRetracted;
import fpml.confirmation.LoanNotificationRetracted.LoanNotificationRetractedBuilder;
import fpml.confirmation.LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl;
import fpml.confirmation.LoanNotificationRetracted.LoanNotificationRetractedImpl;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanNotificationRetractedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message used to indicate a retraction of a loan notification.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanNotificationRetracted", builder=LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl.class, version="${project.version}")
public interface LoanNotificationRetracted extends NonCorrectableRequestMessage {

	LoanNotificationRetractedMeta metaData = new LoanNotificationRetractedMeta();

	/*********************** Getter Methods  ***********************/
	LoanIdentifiersModel getLoanIdentifiersModel();
	Party getParty();
	UnprocessedElementWrapper getOriginalMessage();

	/*********************** Build Methods  ***********************/
	LoanNotificationRetracted build();
	
	LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder();
	
	static LoanNotificationRetracted.LoanNotificationRetractedBuilder builder() {
		return new LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanNotificationRetracted> getType() {
		return LoanNotificationRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.class, getLoanIdentifiersModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationRetractedBuilder extends LoanNotificationRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getOrCreateLoanIdentifiersModel();
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getLoanIdentifiersModel();
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setActualBuild(Integer actualBuild);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setHeader(RequestMessageHeader header);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setValidationModel(ValidationModel validationModel);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setParty(Party party);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.LoanIdentifiersModelBuilder.class, getLoanIdentifiersModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
		}
		

		LoanNotificationRetracted.LoanNotificationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationRetracted  ***********************/
	class LoanNotificationRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements LoanNotificationRetracted {
		private final LoanIdentifiersModel loanIdentifiersModel;
		private final Party party;
		private final UnprocessedElementWrapper originalMessage;
		
		protected LoanNotificationRetractedImpl(LoanNotificationRetracted.LoanNotificationRetractedBuilder builder) {
			super(builder);
			this.loanIdentifiersModel = ofNullable(builder.getLoanIdentifiersModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanIdentifiersModel getLoanIdentifiersModel() {
			return loanIdentifiersModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public LoanNotificationRetracted build() {
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder() {
			LoanNotificationRetracted.LoanNotificationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationRetracted.LoanNotificationRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanIdentifiersModel()).ifPresent(builder::setLoanIdentifiersModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationRetracted _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationRetracted {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel + ", " +
				"party=" + this.party + ", " +
				"originalMessage=" + this.originalMessage +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationRetracted  ***********************/
	class LoanNotificationRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements LoanNotificationRetracted.LoanNotificationRetractedBuilder {
	
		protected LoanIdentifiersModel.LoanIdentifiersModelBuilder loanIdentifiersModel;
		protected Party.PartyBuilder party;
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
	
		public LoanNotificationRetractedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder getLoanIdentifiersModel() {
			return loanIdentifiersModel;
		}
		
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder getOrCreateLoanIdentifiersModel() {
			LoanIdentifiersModel.LoanIdentifiersModelBuilder result;
			if (loanIdentifiersModel!=null) {
				result = loanIdentifiersModel;
			}
			else {
				result = loanIdentifiersModel = LoanIdentifiersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel) {
			this.loanIdentifiersModel = loanIdentifiersModel==null?null:loanIdentifiersModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationRetracted build() {
			return new LoanNotificationRetracted.LoanNotificationRetractedImpl(this);
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder prune() {
			super.prune();
			if (loanIdentifiersModel!=null && !loanIdentifiersModel.prune().hasData()) loanIdentifiersModel = null;
			if (party!=null && !party.prune().hasData()) party = null;
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanIdentifiersModel()!=null && getLoanIdentifiersModel().hasData()) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanNotificationRetracted.LoanNotificationRetractedBuilder o = (LoanNotificationRetracted.LoanNotificationRetractedBuilder) other;
			
			merger.mergeRosetta(getLoanIdentifiersModel(), o.getLoanIdentifiersModel(), this::setLoanIdentifiersModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationRetracted _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationRetractedBuilder {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel + ", " +
				"party=" + this.party + ", " +
				"originalMessage=" + this.originalMessage +
			'}' + " " + super.toString();
		}
	}
}
