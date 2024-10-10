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
import fpml.confirmation.DerivativeCalculationMethod;
import fpml.confirmation.DerivativeCalculationParametersModel;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder;
import fpml.confirmation.DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl;
import fpml.confirmation.DerivativeCalculationProcedure.DerivativeCalculationProcedureImpl;
import fpml.confirmation.meta.DerivativeCalculationProcedureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A description of how a numerical derivative is computed.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeCalculationProcedure", builder=DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl.class, version="${project.version}")
public interface DerivativeCalculationProcedure extends RosettaModelObject {

	DerivativeCalculationProcedureMeta metaData = new DerivativeCalculationProcedureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc.
	 */
	DerivativeCalculationMethod getMethod();
	DerivativeCalculationParametersModel getDerivativeCalculationParametersModel();

	/*********************** Build Methods  ***********************/
	DerivativeCalculationProcedure build();
	
	DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder();
	
	static DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder() {
		return new DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeCalculationProcedure> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DerivativeCalculationProcedure> getType() {
		return DerivativeCalculationProcedure.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("method"), processor, DerivativeCalculationMethod.class, getMethod());
		processRosetta(path.newSubPath("derivativeCalculationParametersModel"), processor, DerivativeCalculationParametersModel.class, getDerivativeCalculationParametersModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeCalculationProcedureBuilder extends DerivativeCalculationProcedure, RosettaModelObjectBuilder {
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getOrCreateMethod();
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getMethod();
		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder getOrCreateDerivativeCalculationParametersModel();
		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder getDerivativeCalculationParametersModel();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setMethod(DerivativeCalculationMethod method);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setDerivativeCalculationParametersModel(DerivativeCalculationParametersModel derivativeCalculationParametersModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("method"), processor, DerivativeCalculationMethod.DerivativeCalculationMethodBuilder.class, getMethod());
			processRosetta(path.newSubPath("derivativeCalculationParametersModel"), processor, DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder.class, getDerivativeCalculationParametersModel());
		}
		

		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativeCalculationProcedure  ***********************/
	class DerivativeCalculationProcedureImpl implements DerivativeCalculationProcedure {
		private final DerivativeCalculationMethod method;
		private final DerivativeCalculationParametersModel derivativeCalculationParametersModel;
		
		protected DerivativeCalculationProcedureImpl(DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder) {
			this.method = ofNullable(builder.getMethod()).map(f->f.build()).orElse(null);
			this.derivativeCalculationParametersModel = ofNullable(builder.getDerivativeCalculationParametersModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("method")
		public DerivativeCalculationMethod getMethod() {
			return method;
		}
		
		@Override
		@RosettaAttribute("derivativeCalculationParametersModel")
		public DerivativeCalculationParametersModel getDerivativeCalculationParametersModel() {
			return derivativeCalculationParametersModel;
		}
		
		@Override
		public DerivativeCalculationProcedure build() {
			return this;
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder() {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder) {
			ofNullable(getMethod()).ifPresent(builder::setMethod);
			ofNullable(getDerivativeCalculationParametersModel()).ifPresent(builder::setDerivativeCalculationParametersModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationProcedure _that = getType().cast(o);
		
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!Objects.equals(derivativeCalculationParametersModel, _that.getDerivativeCalculationParametersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (method != null ? method.hashCode() : 0);
			_result = 31 * _result + (derivativeCalculationParametersModel != null ? derivativeCalculationParametersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationProcedure {" +
				"method=" + this.method + ", " +
				"derivativeCalculationParametersModel=" + this.derivativeCalculationParametersModel +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeCalculationProcedure  ***********************/
	class DerivativeCalculationProcedureBuilderImpl implements DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder {
	
		protected DerivativeCalculationMethod.DerivativeCalculationMethodBuilder method;
		protected DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder derivativeCalculationParametersModel;
	
		public DerivativeCalculationProcedureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("method")
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getMethod() {
			return method;
		}
		
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getOrCreateMethod() {
			DerivativeCalculationMethod.DerivativeCalculationMethodBuilder result;
			if (method!=null) {
				result = method;
			}
			else {
				result = method = DerivativeCalculationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("derivativeCalculationParametersModel")
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder getDerivativeCalculationParametersModel() {
			return derivativeCalculationParametersModel;
		}
		
		@Override
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder getOrCreateDerivativeCalculationParametersModel() {
			DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder result;
			if (derivativeCalculationParametersModel!=null) {
				result = derivativeCalculationParametersModel;
			}
			else {
				result = derivativeCalculationParametersModel = DerivativeCalculationParametersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("method")
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setMethod(DerivativeCalculationMethod method) {
			this.method = method==null?null:method.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("derivativeCalculationParametersModel")
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setDerivativeCalculationParametersModel(DerivativeCalculationParametersModel derivativeCalculationParametersModel) {
			this.derivativeCalculationParametersModel = derivativeCalculationParametersModel==null?null:derivativeCalculationParametersModel.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeCalculationProcedure build() {
			return new DerivativeCalculationProcedure.DerivativeCalculationProcedureImpl(this);
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder prune() {
			if (method!=null && !method.prune().hasData()) method = null;
			if (derivativeCalculationParametersModel!=null && !derivativeCalculationParametersModel.prune().hasData()) derivativeCalculationParametersModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMethod()!=null && getMethod().hasData()) return true;
			if (getDerivativeCalculationParametersModel()!=null && getDerivativeCalculationParametersModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder o = (DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder) other;
			
			merger.mergeRosetta(getMethod(), o.getMethod(), this::setMethod);
			merger.mergeRosetta(getDerivativeCalculationParametersModel(), o.getDerivativeCalculationParametersModel(), this::setDerivativeCalculationParametersModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationProcedure _that = getType().cast(o);
		
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!Objects.equals(derivativeCalculationParametersModel, _that.getDerivativeCalculationParametersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (method != null ? method.hashCode() : 0);
			_result = 31 * _result + (derivativeCalculationParametersModel != null ? derivativeCalculationParametersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationProcedureBuilder {" +
				"method=" + this.method + ", " +
				"derivativeCalculationParametersModel=" + this.derivativeCalculationParametersModel +
			'}';
		}
	}
}
