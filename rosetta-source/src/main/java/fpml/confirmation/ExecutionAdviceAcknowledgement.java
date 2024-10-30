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
import fpml.confirmation.ExecutionAdviceAcknowledgement;
import fpml.confirmation.ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder;
import fpml.confirmation.ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilderImpl;
import fpml.confirmation.ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExecutionAdviceAcknowledgementMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExecutionAdviceAcknowledgement", builder=ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExecutionAdviceAcknowledgement extends EventRequestAcknowledgement {

	ExecutionAdviceAcknowledgementMeta metaData = new ExecutionAdviceAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExecutionAdviceAcknowledgement build();
	
	ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder toBuilder();
	
	static ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder builder() {
		return new ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAdviceAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionAdviceAcknowledgement> getType() {
		return ExecutionAdviceAcknowledgement.class;
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
	interface ExecutionAdviceAcknowledgementBuilder extends ExecutionAdviceAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setActualBuild(Integer actualBuild);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAdviceAcknowledgement  ***********************/
	class ExecutionAdviceAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements ExecutionAdviceAcknowledgement {
		
		protected ExecutionAdviceAcknowledgementImpl(ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExecutionAdviceAcknowledgement build() {
			return this;
		}
		
		@Override
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder toBuilder() {
			ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder builder) {
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
			return "ExecutionAdviceAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAdviceAcknowledgement  ***********************/
	class ExecutionAdviceAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder {
	
	
		public ExecutionAdviceAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionAdviceAcknowledgement build() {
			return new ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementImpl(this);
		}
		
		@Override
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder prune() {
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
		public ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder o = (ExecutionAdviceAcknowledgement.ExecutionAdviceAcknowledgementBuilder) other;
			
			
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
			return "ExecutionAdviceAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
