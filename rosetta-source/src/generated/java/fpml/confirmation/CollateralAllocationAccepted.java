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
import fpml.confirmation.CollateralAllocationAccepted;
import fpml.confirmation.CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder;
import fpml.confirmation.CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl;
import fpml.confirmation.CollateralAllocationAccepted.CollateralAllocationAcceptedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CollateralAllocationAcceptedMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralAllocationAccepted", builder=CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl.class, version="${project.version}")
public interface CollateralAllocationAccepted extends ResponseMessage {

	CollateralAllocationAcceptedMeta metaData = new CollateralAllocationAcceptedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationAccepted build();
	
	CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder();
	
	static CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder() {
		return new CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationAccepted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralAllocationAccepted> getType() {
		return CollateralAllocationAccepted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralAllocationAcceptedBuilder extends CollateralAllocationAccepted, ResponseMessage.ResponseMessageBuilder {
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setExpectedBuild(Integer expectedBuild);
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setActualBuild(Integer actualBuild);
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setHeader(ResponseMessageHeader header);
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setValidationModel(ValidationModel validationModel);
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
		}
		

		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationAccepted  ***********************/
	class CollateralAllocationAcceptedImpl extends ResponseMessage.ResponseMessageImpl implements CollateralAllocationAccepted {
		
		protected CollateralAllocationAcceptedImpl(CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationAccepted build() {
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder() {
			CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder) {
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
			return "CollateralAllocationAccepted {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationAccepted  ***********************/
	class CollateralAllocationAcceptedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder {
	
	
		public CollateralAllocationAcceptedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted build() {
			return new CollateralAllocationAccepted.CollateralAllocationAcceptedImpl(this);
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder prune() {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder o = (CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder) other;
			
			
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
			return "CollateralAllocationAcceptedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
