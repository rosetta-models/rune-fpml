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
import fpml.confirmation.Acknowledgement;
import fpml.confirmation.Acknowledgement.AcknowledgementBuilder;
import fpml.confirmation.Acknowledgement.AcknowledgementBuilderImpl;
import fpml.confirmation.Acknowledgement.AcknowledgementImpl;
import fpml.confirmation.CollateralAllocationAcknowledgement;
import fpml.confirmation.CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder;
import fpml.confirmation.CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl;
import fpml.confirmation.CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CollateralAllocationAcknowledgementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralAllocationAcknowledgement", builder=CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl.class, version="${project.version}")
public interface CollateralAllocationAcknowledgement extends Acknowledgement {

	CollateralAllocationAcknowledgementMeta metaData = new CollateralAllocationAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationAcknowledgement build();
	
	CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder();
	
	static CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder() {
		return new CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralAllocationAcknowledgement> getType() {
		return CollateralAllocationAcknowledgement.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralAllocationAcknowledgementBuilder extends CollateralAllocationAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setActualBuild(Integer actualBuild);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		}
		

		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationAcknowledgement  ***********************/
	class CollateralAllocationAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements CollateralAllocationAcknowledgement {
		
		protected CollateralAllocationAcknowledgementImpl(CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationAcknowledgement build() {
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder() {
			CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder) {
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
			return "CollateralAllocationAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationAcknowledgement  ***********************/
	class CollateralAllocationAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl  implements CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder {
	
	
		public CollateralAllocationAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement build() {
			return new CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementImpl(this);
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder prune() {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder o = (CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder) other;
			
			
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
			return "CollateralAllocationAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
