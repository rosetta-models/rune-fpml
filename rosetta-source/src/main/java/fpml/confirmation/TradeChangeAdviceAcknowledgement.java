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
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeChangeAdviceAcknowledgement;
import fpml.confirmation.TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder;
import fpml.confirmation.TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilderImpl;
import fpml.confirmation.TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementImpl;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeChangeAdviceAcknowledgementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeAdviceAcknowledgement", builder=TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilderImpl.class, version="${project.version}")
public interface TradeChangeAdviceAcknowledgement extends EventRequestAcknowledgement {

	TradeChangeAdviceAcknowledgementMeta metaData = new TradeChangeAdviceAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeChangeAdviceAcknowledgement build();
	
	TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder toBuilder();
	
	static TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder builder() {
		return new TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdviceAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeAdviceAcknowledgement> getType() {
		return TradeChangeAdviceAcknowledgement.class;
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
	interface TradeChangeAdviceAcknowledgementBuilder extends TradeChangeAdviceAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setActualBuild(Integer actualBuild);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdviceAcknowledgement  ***********************/
	class TradeChangeAdviceAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements TradeChangeAdviceAcknowledgement {
		
		protected TradeChangeAdviceAcknowledgementImpl(TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeChangeAdviceAcknowledgement build() {
			return this;
		}
		
		@Override
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder toBuilder() {
			TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "TradeChangeAdviceAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdviceAcknowledgement  ***********************/
	class TradeChangeAdviceAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder {
	
	
		public TradeChangeAdviceAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeAdviceAcknowledgement build() {
			return new TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementImpl(this);
		}
		
		@Override
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder prune() {
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
		public TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder o = (TradeChangeAdviceAcknowledgement.TradeChangeAdviceAcknowledgementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "TradeChangeAdviceAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
