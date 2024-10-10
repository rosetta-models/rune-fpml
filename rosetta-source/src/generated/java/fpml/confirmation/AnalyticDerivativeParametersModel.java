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
import fpml.confirmation.AnalyticDerivativeParametersModel;
import fpml.confirmation.AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder;
import fpml.confirmation.AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilderImpl;
import fpml.confirmation.AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelImpl;
import fpml.confirmation.meta.AnalyticDerivativeParametersModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Parameters used in the computation of a derivative using analytical (closed form formula) techiques.
 * @version ${project.version}
 */
@RosettaDataType(value="AnalyticDerivativeParametersModel", builder=AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilderImpl.class, version="${project.version}")
public interface AnalyticDerivativeParametersModel extends RosettaModelObject {

	AnalyticDerivativeParametersModelMeta metaData = new AnalyticDerivativeParametersModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The formula used to compute the derivative (perhaps could be updated to use the Formula type in EQS.).
	 */
	String getDerivativeFormula();

	/*********************** Build Methods  ***********************/
	AnalyticDerivativeParametersModel build();
	
	AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder toBuilder();
	
	static AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder builder() {
		return new AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnalyticDerivativeParametersModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AnalyticDerivativeParametersModel> getType() {
		return AnalyticDerivativeParametersModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("derivativeFormula"), String.class, getDerivativeFormula(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnalyticDerivativeParametersModelBuilder extends AnalyticDerivativeParametersModel, RosettaModelObjectBuilder {
		AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder setDerivativeFormula(String derivativeFormula);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("derivativeFormula"), String.class, getDerivativeFormula(), this);
		}
		

		AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder prune();
	}

	/*********************** Immutable Implementation of AnalyticDerivativeParametersModel  ***********************/
	class AnalyticDerivativeParametersModelImpl implements AnalyticDerivativeParametersModel {
		private final String derivativeFormula;
		
		protected AnalyticDerivativeParametersModelImpl(AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder builder) {
			this.derivativeFormula = builder.getDerivativeFormula();
		}
		
		@Override
		@RosettaAttribute("derivativeFormula")
		public String getDerivativeFormula() {
			return derivativeFormula;
		}
		
		@Override
		public AnalyticDerivativeParametersModel build() {
			return this;
		}
		
		@Override
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder toBuilder() {
			AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder builder) {
			ofNullable(getDerivativeFormula()).ifPresent(builder::setDerivativeFormula);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnalyticDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(derivativeFormula, _that.getDerivativeFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivativeFormula != null ? derivativeFormula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnalyticDerivativeParametersModel {" +
				"derivativeFormula=" + this.derivativeFormula +
			'}';
		}
	}

	/*********************** Builder Implementation of AnalyticDerivativeParametersModel  ***********************/
	class AnalyticDerivativeParametersModelBuilderImpl implements AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder {
	
		protected String derivativeFormula;
	
		public AnalyticDerivativeParametersModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("derivativeFormula")
		public String getDerivativeFormula() {
			return derivativeFormula;
		}
		
		@Override
		@RosettaAttribute("derivativeFormula")
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder setDerivativeFormula(String derivativeFormula) {
			this.derivativeFormula = derivativeFormula==null?null:derivativeFormula;
			return this;
		}
		
		@Override
		public AnalyticDerivativeParametersModel build() {
			return new AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelImpl(this);
		}
		
		@Override
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDerivativeFormula()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder o = (AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder) other;
			
			
			merger.mergeBasic(getDerivativeFormula(), o.getDerivativeFormula(), this::setDerivativeFormula);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnalyticDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(derivativeFormula, _that.getDerivativeFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivativeFormula != null ? derivativeFormula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnalyticDerivativeParametersModelBuilder {" +
				"derivativeFormula=" + this.derivativeFormula +
			'}';
		}
	}
}
