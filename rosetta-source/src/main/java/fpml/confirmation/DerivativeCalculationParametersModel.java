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
import fpml.confirmation.DerivativeCalculationParametersModel;
import fpml.confirmation.DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder;
import fpml.confirmation.DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilderImpl;
import fpml.confirmation.DerivativeCalculationParametersModel.DerivativeCalculationParametersModelImpl;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel;
import fpml.confirmation.SubstitutionDerivativeParametersModel;
import fpml.confirmation.meta.DerivativeCalculationParametersModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Parameters used in the computation of a derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeCalculationParametersModel", builder=DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilderImpl.class, version="${project.version}")
public interface DerivativeCalculationParametersModel extends RosettaModelObject {

	DerivativeCalculationParametersModelMeta metaData = new DerivativeCalculationParametersModelMeta();

	/*********************** Getter Methods  ***********************/
	FiniteDifferenceDerivativeParametersModel getFiniteDifferenceDerivativeParametersModel();
	AnalyticDerivativeParametersModel getAnalyticDerivativeParametersModel();
	SubstitutionDerivativeParametersModel getSubstitutionDerivativeParametersModel();

	/*********************** Build Methods  ***********************/
	DerivativeCalculationParametersModel build();
	
	DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder toBuilder();
	
	static DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder builder() {
		return new DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeCalculationParametersModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DerivativeCalculationParametersModel> getType() {
		return DerivativeCalculationParametersModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("finiteDifferenceDerivativeParametersModel"), processor, FiniteDifferenceDerivativeParametersModel.class, getFiniteDifferenceDerivativeParametersModel());
		processRosetta(path.newSubPath("analyticDerivativeParametersModel"), processor, AnalyticDerivativeParametersModel.class, getAnalyticDerivativeParametersModel());
		processRosetta(path.newSubPath("substitutionDerivativeParametersModel"), processor, SubstitutionDerivativeParametersModel.class, getSubstitutionDerivativeParametersModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeCalculationParametersModelBuilder extends DerivativeCalculationParametersModel, RosettaModelObjectBuilder {
		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder getOrCreateFiniteDifferenceDerivativeParametersModel();
		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder getFiniteDifferenceDerivativeParametersModel();
		AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder getOrCreateAnalyticDerivativeParametersModel();
		AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder getAnalyticDerivativeParametersModel();
		SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder getOrCreateSubstitutionDerivativeParametersModel();
		SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder getSubstitutionDerivativeParametersModel();
		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setFiniteDifferenceDerivativeParametersModel(FiniteDifferenceDerivativeParametersModel finiteDifferenceDerivativeParametersModel);
		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setAnalyticDerivativeParametersModel(AnalyticDerivativeParametersModel analyticDerivativeParametersModel);
		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setSubstitutionDerivativeParametersModel(SubstitutionDerivativeParametersModel substitutionDerivativeParametersModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("finiteDifferenceDerivativeParametersModel"), processor, FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder.class, getFiniteDifferenceDerivativeParametersModel());
			processRosetta(path.newSubPath("analyticDerivativeParametersModel"), processor, AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder.class, getAnalyticDerivativeParametersModel());
			processRosetta(path.newSubPath("substitutionDerivativeParametersModel"), processor, SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder.class, getSubstitutionDerivativeParametersModel());
		}
		

		DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativeCalculationParametersModel  ***********************/
	class DerivativeCalculationParametersModelImpl implements DerivativeCalculationParametersModel {
		private final FiniteDifferenceDerivativeParametersModel finiteDifferenceDerivativeParametersModel;
		private final AnalyticDerivativeParametersModel analyticDerivativeParametersModel;
		private final SubstitutionDerivativeParametersModel substitutionDerivativeParametersModel;
		
		protected DerivativeCalculationParametersModelImpl(DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder builder) {
			this.finiteDifferenceDerivativeParametersModel = ofNullable(builder.getFiniteDifferenceDerivativeParametersModel()).map(f->f.build()).orElse(null);
			this.analyticDerivativeParametersModel = ofNullable(builder.getAnalyticDerivativeParametersModel()).map(f->f.build()).orElse(null);
			this.substitutionDerivativeParametersModel = ofNullable(builder.getSubstitutionDerivativeParametersModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("finiteDifferenceDerivativeParametersModel")
		public FiniteDifferenceDerivativeParametersModel getFiniteDifferenceDerivativeParametersModel() {
			return finiteDifferenceDerivativeParametersModel;
		}
		
		@Override
		@RosettaAttribute("analyticDerivativeParametersModel")
		public AnalyticDerivativeParametersModel getAnalyticDerivativeParametersModel() {
			return analyticDerivativeParametersModel;
		}
		
		@Override
		@RosettaAttribute("substitutionDerivativeParametersModel")
		public SubstitutionDerivativeParametersModel getSubstitutionDerivativeParametersModel() {
			return substitutionDerivativeParametersModel;
		}
		
		@Override
		public DerivativeCalculationParametersModel build() {
			return this;
		}
		
		@Override
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder toBuilder() {
			DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder builder) {
			ofNullable(getFiniteDifferenceDerivativeParametersModel()).ifPresent(builder::setFiniteDifferenceDerivativeParametersModel);
			ofNullable(getAnalyticDerivativeParametersModel()).ifPresent(builder::setAnalyticDerivativeParametersModel);
			ofNullable(getSubstitutionDerivativeParametersModel()).ifPresent(builder::setSubstitutionDerivativeParametersModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(finiteDifferenceDerivativeParametersModel, _that.getFiniteDifferenceDerivativeParametersModel())) return false;
			if (!Objects.equals(analyticDerivativeParametersModel, _that.getAnalyticDerivativeParametersModel())) return false;
			if (!Objects.equals(substitutionDerivativeParametersModel, _that.getSubstitutionDerivativeParametersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finiteDifferenceDerivativeParametersModel != null ? finiteDifferenceDerivativeParametersModel.hashCode() : 0);
			_result = 31 * _result + (analyticDerivativeParametersModel != null ? analyticDerivativeParametersModel.hashCode() : 0);
			_result = 31 * _result + (substitutionDerivativeParametersModel != null ? substitutionDerivativeParametersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationParametersModel {" +
				"finiteDifferenceDerivativeParametersModel=" + this.finiteDifferenceDerivativeParametersModel + ", " +
				"analyticDerivativeParametersModel=" + this.analyticDerivativeParametersModel + ", " +
				"substitutionDerivativeParametersModel=" + this.substitutionDerivativeParametersModel +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeCalculationParametersModel  ***********************/
	class DerivativeCalculationParametersModelBuilderImpl implements DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder {
	
		protected FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder finiteDifferenceDerivativeParametersModel;
		protected AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder analyticDerivativeParametersModel;
		protected SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder substitutionDerivativeParametersModel;
	
		public DerivativeCalculationParametersModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("finiteDifferenceDerivativeParametersModel")
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder getFiniteDifferenceDerivativeParametersModel() {
			return finiteDifferenceDerivativeParametersModel;
		}
		
		@Override
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder getOrCreateFiniteDifferenceDerivativeParametersModel() {
			FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder result;
			if (finiteDifferenceDerivativeParametersModel!=null) {
				result = finiteDifferenceDerivativeParametersModel;
			}
			else {
				result = finiteDifferenceDerivativeParametersModel = FiniteDifferenceDerivativeParametersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("analyticDerivativeParametersModel")
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder getAnalyticDerivativeParametersModel() {
			return analyticDerivativeParametersModel;
		}
		
		@Override
		public AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder getOrCreateAnalyticDerivativeParametersModel() {
			AnalyticDerivativeParametersModel.AnalyticDerivativeParametersModelBuilder result;
			if (analyticDerivativeParametersModel!=null) {
				result = analyticDerivativeParametersModel;
			}
			else {
				result = analyticDerivativeParametersModel = AnalyticDerivativeParametersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("substitutionDerivativeParametersModel")
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder getSubstitutionDerivativeParametersModel() {
			return substitutionDerivativeParametersModel;
		}
		
		@Override
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder getOrCreateSubstitutionDerivativeParametersModel() {
			SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder result;
			if (substitutionDerivativeParametersModel!=null) {
				result = substitutionDerivativeParametersModel;
			}
			else {
				result = substitutionDerivativeParametersModel = SubstitutionDerivativeParametersModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finiteDifferenceDerivativeParametersModel")
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setFiniteDifferenceDerivativeParametersModel(FiniteDifferenceDerivativeParametersModel finiteDifferenceDerivativeParametersModel) {
			this.finiteDifferenceDerivativeParametersModel = finiteDifferenceDerivativeParametersModel==null?null:finiteDifferenceDerivativeParametersModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("analyticDerivativeParametersModel")
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setAnalyticDerivativeParametersModel(AnalyticDerivativeParametersModel analyticDerivativeParametersModel) {
			this.analyticDerivativeParametersModel = analyticDerivativeParametersModel==null?null:analyticDerivativeParametersModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("substitutionDerivativeParametersModel")
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder setSubstitutionDerivativeParametersModel(SubstitutionDerivativeParametersModel substitutionDerivativeParametersModel) {
			this.substitutionDerivativeParametersModel = substitutionDerivativeParametersModel==null?null:substitutionDerivativeParametersModel.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeCalculationParametersModel build() {
			return new DerivativeCalculationParametersModel.DerivativeCalculationParametersModelImpl(this);
		}
		
		@Override
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder prune() {
			if (finiteDifferenceDerivativeParametersModel!=null && !finiteDifferenceDerivativeParametersModel.prune().hasData()) finiteDifferenceDerivativeParametersModel = null;
			if (analyticDerivativeParametersModel!=null && !analyticDerivativeParametersModel.prune().hasData()) analyticDerivativeParametersModel = null;
			if (substitutionDerivativeParametersModel!=null && !substitutionDerivativeParametersModel.prune().hasData()) substitutionDerivativeParametersModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFiniteDifferenceDerivativeParametersModel()!=null && getFiniteDifferenceDerivativeParametersModel().hasData()) return true;
			if (getAnalyticDerivativeParametersModel()!=null && getAnalyticDerivativeParametersModel().hasData()) return true;
			if (getSubstitutionDerivativeParametersModel()!=null && getSubstitutionDerivativeParametersModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder o = (DerivativeCalculationParametersModel.DerivativeCalculationParametersModelBuilder) other;
			
			merger.mergeRosetta(getFiniteDifferenceDerivativeParametersModel(), o.getFiniteDifferenceDerivativeParametersModel(), this::setFiniteDifferenceDerivativeParametersModel);
			merger.mergeRosetta(getAnalyticDerivativeParametersModel(), o.getAnalyticDerivativeParametersModel(), this::setAnalyticDerivativeParametersModel);
			merger.mergeRosetta(getSubstitutionDerivativeParametersModel(), o.getSubstitutionDerivativeParametersModel(), this::setSubstitutionDerivativeParametersModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(finiteDifferenceDerivativeParametersModel, _that.getFiniteDifferenceDerivativeParametersModel())) return false;
			if (!Objects.equals(analyticDerivativeParametersModel, _that.getAnalyticDerivativeParametersModel())) return false;
			if (!Objects.equals(substitutionDerivativeParametersModel, _that.getSubstitutionDerivativeParametersModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finiteDifferenceDerivativeParametersModel != null ? finiteDifferenceDerivativeParametersModel.hashCode() : 0);
			_result = 31 * _result + (analyticDerivativeParametersModel != null ? analyticDerivativeParametersModel.hashCode() : 0);
			_result = 31 * _result + (substitutionDerivativeParametersModel != null ? substitutionDerivativeParametersModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationParametersModelBuilder {" +
				"finiteDifferenceDerivativeParametersModel=" + this.finiteDifferenceDerivativeParametersModel + ", " +
				"analyticDerivativeParametersModel=" + this.analyticDerivativeParametersModel + ", " +
				"substitutionDerivativeParametersModel=" + this.substitutionDerivativeParametersModel +
			'}';
		}
	}
}
