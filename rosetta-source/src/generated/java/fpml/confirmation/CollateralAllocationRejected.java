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
import fpml.confirmation.CollateralAllocationRejected;
import fpml.confirmation.CollateralAllocationRejected.CollateralAllocationRejectedBuilder;
import fpml.confirmation.CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl;
import fpml.confirmation.CollateralAllocationRejected.CollateralAllocationRejectedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CollateralAllocationRejectedMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralAllocationRejected", builder=CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl.class, version="${project.version}")
public interface CollateralAllocationRejected extends Exception {

	CollateralAllocationRejectedMeta metaData = new CollateralAllocationRejectedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationRejected build();
	
	CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder();
	
	static CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder() {
		return new CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationRejected> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralAllocationRejected> getType() {
		return CollateralAllocationRejected.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.class, getExceptionModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralAllocationRejectedBuilder extends CollateralAllocationRejected, Exception.ExceptionBuilder {
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExpectedBuild(Integer expectedBuild);
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setActualBuild(Integer actualBuild);
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setHeader(ExceptionMessageHeader header);
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setValidationModel(ValidationModel validationModel);
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		CollateralAllocationRejected.CollateralAllocationRejectedBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationRejected  ***********************/
	class CollateralAllocationRejectedImpl extends Exception.ExceptionImpl implements CollateralAllocationRejected {
		
		protected CollateralAllocationRejectedImpl(CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationRejected build() {
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder() {
			CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder) {
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
			return "CollateralAllocationRejected {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationRejected  ***********************/
	class CollateralAllocationRejectedBuilderImpl extends Exception.ExceptionBuilderImpl  implements CollateralAllocationRejected.CollateralAllocationRejectedBuilder {
	
	
		public CollateralAllocationRejectedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public CollateralAllocationRejected build() {
			return new CollateralAllocationRejected.CollateralAllocationRejectedImpl(this);
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder prune() {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CollateralAllocationRejected.CollateralAllocationRejectedBuilder o = (CollateralAllocationRejected.CollateralAllocationRejectedBuilder) other;
			
			
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
			return "CollateralAllocationRejectedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
