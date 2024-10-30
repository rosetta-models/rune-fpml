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
import fpml.confirmation.EventRequestAcknowledgement;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilder;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementImpl;
import fpml.confirmation.ExecutionAcknowledgement;
import fpml.confirmation.ExecutionAcknowledgement.ExecutionAcknowledgementBuilder;
import fpml.confirmation.ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl;
import fpml.confirmation.ExecutionAcknowledgement.ExecutionAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExecutionAcknowledgementMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExecutionAcknowledgement", builder=ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExecutionAcknowledgement extends EventRequestAcknowledgement {

	ExecutionAcknowledgementMeta metaData = new ExecutionAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExecutionAcknowledgement build();
	
	ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder();
	
	static ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder() {
		return new ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionAcknowledgement> getType() {
		return ExecutionAcknowledgement.class;
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
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionAcknowledgementBuilder extends ExecutionAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setActualBuild(Integer actualBuild);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAcknowledgement  ***********************/
	class ExecutionAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements ExecutionAcknowledgement {
		
		protected ExecutionAcknowledgementImpl(ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExecutionAcknowledgement build() {
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder() {
			ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAcknowledgement  ***********************/
	class ExecutionAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements ExecutionAcknowledgement.ExecutionAcknowledgementBuilder {
	
	
		public ExecutionAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement build() {
			return new ExecutionAcknowledgement.ExecutionAcknowledgementImpl(this);
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExecutionAcknowledgement.ExecutionAcknowledgementBuilder o = (ExecutionAcknowledgement.ExecutionAcknowledgementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
