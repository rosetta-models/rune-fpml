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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.LoanAcknowledgement;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementBuilder;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementBuilderImpl;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementImpl;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.LoanNotificationAcknowledgement;
import fpml.confirmation.LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder;
import fpml.confirmation.LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl;
import fpml.confirmation.LoanNotificationAcknowledgement.LoanNotificationAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanNotificationAcknowledgementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message used to acknowledge a loan notification.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanNotificationAcknowledgement", builder=LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl.class, version="${project.version}")
public interface LoanNotificationAcknowledgement extends LoanAcknowledgement {

	LoanNotificationAcknowledgementMeta metaData = new LoanNotificationAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/
	LoanIdentifiersModel getLoanIdentifiersModel();

	/*********************** Build Methods  ***********************/
	LoanNotificationAcknowledgement build();
	
	LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder();
	
	static LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder() {
		return new LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanNotificationAcknowledgement> getType() {
		return LoanNotificationAcknowledgement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
		processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.class, getLoanIdentifiersModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationAcknowledgementBuilder extends LoanNotificationAcknowledgement, LoanAcknowledgement.LoanAcknowledgementBuilder {
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getOrCreateLoanIdentifiersModel();
		LoanIdentifiersModel.LoanIdentifiersModelBuilder getLoanIdentifiersModel();
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setActualBuild(Integer actualBuild);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
			processRosetta(path.newSubPath("loanIdentifiersModel"), processor, LoanIdentifiersModel.LoanIdentifiersModelBuilder.class, getLoanIdentifiersModel());
		}
		

		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationAcknowledgement  ***********************/
	class LoanNotificationAcknowledgementImpl extends LoanAcknowledgement.LoanAcknowledgementImpl implements LoanNotificationAcknowledgement {
		private final LoanIdentifiersModel loanIdentifiersModel;
		
		protected LoanNotificationAcknowledgementImpl(LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder) {
			super(builder);
			this.loanIdentifiersModel = ofNullable(builder.getLoanIdentifiersModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanIdentifiersModel getLoanIdentifiersModel() {
			return loanIdentifiersModel;
		}
		
		@Override
		public LoanNotificationAcknowledgement build() {
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder() {
			LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanIdentifiersModel()).ifPresent(builder::setLoanIdentifiersModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationAcknowledgement {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationAcknowledgement  ***********************/
	class LoanNotificationAcknowledgementBuilderImpl extends LoanAcknowledgement.LoanAcknowledgementBuilderImpl  implements LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder {
	
		protected LoanIdentifiersModel.LoanIdentifiersModelBuilder loanIdentifiersModel;
	
		public LoanNotificationAcknowledgementBuilderImpl() {
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
		@RosettaAttribute("expectedBuild")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanIdentifiersModel")
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setLoanIdentifiersModel(LoanIdentifiersModel loanIdentifiersModel) {
			this.loanIdentifiersModel = loanIdentifiersModel==null?null:loanIdentifiersModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement build() {
			return new LoanNotificationAcknowledgement.LoanNotificationAcknowledgementImpl(this);
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder prune() {
			super.prune();
			if (loanIdentifiersModel!=null && !loanIdentifiersModel.prune().hasData()) loanIdentifiersModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanIdentifiersModel()!=null && getLoanIdentifiersModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder o = (LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getLoanIdentifiersModel(), o.getLoanIdentifiersModel(), this::setLoanIdentifiersModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(loanIdentifiersModel, _that.getLoanIdentifiersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanIdentifiersModel != null ? loanIdentifiersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationAcknowledgementBuilder {" +
				"loanIdentifiersModel=" + this.loanIdentifiersModel +
			'}' + " " + super.toString();
		}
	}
}
