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
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.TradeReferenceInformationUpdateAcknowledgement;
import fpml.confirmation.TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder;
import fpml.confirmation.TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilderImpl;
import fpml.confirmation.TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementImpl;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeReferenceInformationUpdateAcknowledgementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReferenceInformationUpdateAcknowledgement", builder=TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilderImpl.class, version="${project.version}")
public interface TradeReferenceInformationUpdateAcknowledgement extends EventRequestAcknowledgement {

	TradeReferenceInformationUpdateAcknowledgementMeta metaData = new TradeReferenceInformationUpdateAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeReferenceInformationUpdateAcknowledgement build();
	
	TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder toBuilder();
	
	static TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder builder() {
		return new TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformationUpdateAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeReferenceInformationUpdateAcknowledgement> getType() {
		return TradeReferenceInformationUpdateAcknowledgement.class;
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
	interface TradeReferenceInformationUpdateAcknowledgementBuilder extends TradeReferenceInformationUpdateAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setActualBuild(Integer actualBuild);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformationUpdateAcknowledgement  ***********************/
	class TradeReferenceInformationUpdateAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements TradeReferenceInformationUpdateAcknowledgement {
		
		protected TradeReferenceInformationUpdateAcknowledgementImpl(TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeReferenceInformationUpdateAcknowledgement build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder toBuilder() {
			TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder builder) {
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
			return "TradeReferenceInformationUpdateAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformationUpdateAcknowledgement  ***********************/
	class TradeReferenceInformationUpdateAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder {
	
	
		public TradeReferenceInformationUpdateAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateAcknowledgement build() {
			return new TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementImpl(this);
		}
		
		@Override
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder prune() {
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
		public TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder o = (TradeReferenceInformationUpdateAcknowledgement.TradeReferenceInformationUpdateAcknowledgementBuilder) other;
			
			
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
			return "TradeReferenceInformationUpdateAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
