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
import fpml.confirmation.MaturityAcknowledgement;
import fpml.confirmation.MaturityAcknowledgement.MaturityAcknowledgementBuilder;
import fpml.confirmation.MaturityAcknowledgement.MaturityAcknowledgementBuilderImpl;
import fpml.confirmation.MaturityAcknowledgement.MaturityAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.MaturityAcknowledgementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="MaturityAcknowledgement", builder=MaturityAcknowledgement.MaturityAcknowledgementBuilderImpl.class, version="${project.version}")
public interface MaturityAcknowledgement extends EventRequestAcknowledgement {

	MaturityAcknowledgementMeta metaData = new MaturityAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MaturityAcknowledgement build();
	
	MaturityAcknowledgement.MaturityAcknowledgementBuilder toBuilder();
	
	static MaturityAcknowledgement.MaturityAcknowledgementBuilder builder() {
		return new MaturityAcknowledgement.MaturityAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MaturityAcknowledgement> getType() {
		return MaturityAcknowledgement.class;
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
	interface MaturityAcknowledgementBuilder extends MaturityAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setActualBuild(Integer actualBuild);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		MaturityAcknowledgement.MaturityAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		MaturityAcknowledgement.MaturityAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityAcknowledgement  ***********************/
	class MaturityAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements MaturityAcknowledgement {
		
		protected MaturityAcknowledgementImpl(MaturityAcknowledgement.MaturityAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public MaturityAcknowledgement build() {
			return this;
		}
		
		@Override
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder toBuilder() {
			MaturityAcknowledgement.MaturityAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityAcknowledgement.MaturityAcknowledgementBuilder builder) {
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
			return "MaturityAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityAcknowledgement  ***********************/
	class MaturityAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements MaturityAcknowledgement.MaturityAcknowledgementBuilder {
	
	
		public MaturityAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public MaturityAcknowledgement build() {
			return new MaturityAcknowledgement.MaturityAcknowledgementImpl(this);
		}
		
		@Override
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder prune() {
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
		public MaturityAcknowledgement.MaturityAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MaturityAcknowledgement.MaturityAcknowledgementBuilder o = (MaturityAcknowledgement.MaturityAcknowledgementBuilder) other;
			
			
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
			return "MaturityAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
