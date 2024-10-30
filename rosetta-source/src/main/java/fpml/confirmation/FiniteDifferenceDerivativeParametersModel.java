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
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilderImpl;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelImpl;
import fpml.confirmation.PerturbationType;
import fpml.confirmation.meta.FiniteDifferenceDerivativeParametersModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Parameters used in the computation of a derivative using numerical (finite difference) techniques.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FiniteDifferenceDerivativeParametersModel", builder=FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FiniteDifferenceDerivativeParametersModel extends RosettaModelObject {

	FiniteDifferenceDerivativeParametersModelMeta metaData = new FiniteDifferenceDerivativeParametersModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The size and direction of the perturbation used to compute the derivative, e.g. 0.0001 = 1 bp.
	 */
	BigDecimal getPerturbationAmount();
	/**
	 * The value is calculated by perturbing by the perturbationAmount and then the negative of the perturbationAmount and then averaging the two values (i.e. the value is half of the difference between perturbing up and perturbing down).
	 */
	Boolean getAveraged();
	/**
	 * The type of perturbation, if any, used to compute the derivative (Absolute vs Relative).
	 */
	PerturbationType getPerturbationType();

	/*********************** Build Methods  ***********************/
	FiniteDifferenceDerivativeParametersModel build();
	
	FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder toBuilder();
	
	static FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder builder() {
		return new FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FiniteDifferenceDerivativeParametersModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FiniteDifferenceDerivativeParametersModel> getType() {
		return FiniteDifferenceDerivativeParametersModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("perturbationAmount"), BigDecimal.class, getPerturbationAmount(), this);
		processor.processBasic(path.newSubPath("averaged"), Boolean.class, getAveraged(), this);
		processRosetta(path.newSubPath("perturbationType"), processor, PerturbationType.class, getPerturbationType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FiniteDifferenceDerivativeParametersModelBuilder extends FiniteDifferenceDerivativeParametersModel, RosettaModelObjectBuilder {
		PerturbationType.PerturbationTypeBuilder getOrCreatePerturbationType();
		PerturbationType.PerturbationTypeBuilder getPerturbationType();
		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setPerturbationAmount(BigDecimal perturbationAmount);
		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setAveraged(Boolean averaged);
		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setPerturbationType(PerturbationType perturbationType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("perturbationAmount"), BigDecimal.class, getPerturbationAmount(), this);
			processor.processBasic(path.newSubPath("averaged"), Boolean.class, getAveraged(), this);
			processRosetta(path.newSubPath("perturbationType"), processor, PerturbationType.PerturbationTypeBuilder.class, getPerturbationType());
		}
		

		FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder prune();
	}

	/*********************** Immutable Implementation of FiniteDifferenceDerivativeParametersModel  ***********************/
	class FiniteDifferenceDerivativeParametersModelImpl implements FiniteDifferenceDerivativeParametersModel {
		private final BigDecimal perturbationAmount;
		private final Boolean averaged;
		private final PerturbationType perturbationType;
		
		protected FiniteDifferenceDerivativeParametersModelImpl(FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder builder) {
			this.perturbationAmount = builder.getPerturbationAmount();
			this.averaged = builder.getAveraged();
			this.perturbationType = ofNullable(builder.getPerturbationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("perturbationAmount")
		public BigDecimal getPerturbationAmount() {
			return perturbationAmount;
		}
		
		@Override
		@RosettaAttribute("averaged")
		public Boolean getAveraged() {
			return averaged;
		}
		
		@Override
		@RosettaAttribute("perturbationType")
		public PerturbationType getPerturbationType() {
			return perturbationType;
		}
		
		@Override
		public FiniteDifferenceDerivativeParametersModel build() {
			return this;
		}
		
		@Override
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder toBuilder() {
			FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder builder) {
			ofNullable(getPerturbationAmount()).ifPresent(builder::setPerturbationAmount);
			ofNullable(getAveraged()).ifPresent(builder::setAveraged);
			ofNullable(getPerturbationType()).ifPresent(builder::setPerturbationType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FiniteDifferenceDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(perturbationAmount, _that.getPerturbationAmount())) return false;
			if (!Objects.equals(averaged, _that.getAveraged())) return false;
			if (!Objects.equals(perturbationType, _that.getPerturbationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (perturbationAmount != null ? perturbationAmount.hashCode() : 0);
			_result = 31 * _result + (averaged != null ? averaged.hashCode() : 0);
			_result = 31 * _result + (perturbationType != null ? perturbationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FiniteDifferenceDerivativeParametersModel {" +
				"perturbationAmount=" + this.perturbationAmount + ", " +
				"averaged=" + this.averaged + ", " +
				"perturbationType=" + this.perturbationType +
			'}';
		}
	}

	/*********************** Builder Implementation of FiniteDifferenceDerivativeParametersModel  ***********************/
	class FiniteDifferenceDerivativeParametersModelBuilderImpl implements FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder {
	
		protected BigDecimal perturbationAmount;
		protected Boolean averaged;
		protected PerturbationType.PerturbationTypeBuilder perturbationType;
	
		public FiniteDifferenceDerivativeParametersModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("perturbationAmount")
		public BigDecimal getPerturbationAmount() {
			return perturbationAmount;
		}
		
		@Override
		@RosettaAttribute("averaged")
		public Boolean getAveraged() {
			return averaged;
		}
		
		@Override
		@RosettaAttribute("perturbationType")
		public PerturbationType.PerturbationTypeBuilder getPerturbationType() {
			return perturbationType;
		}
		
		@Override
		public PerturbationType.PerturbationTypeBuilder getOrCreatePerturbationType() {
			PerturbationType.PerturbationTypeBuilder result;
			if (perturbationType!=null) {
				result = perturbationType;
			}
			else {
				result = perturbationType = PerturbationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("perturbationAmount")
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setPerturbationAmount(BigDecimal perturbationAmount) {
			this.perturbationAmount = perturbationAmount==null?null:perturbationAmount;
			return this;
		}
		@Override
		@RosettaAttribute("averaged")
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setAveraged(Boolean averaged) {
			this.averaged = averaged==null?null:averaged;
			return this;
		}
		@Override
		@RosettaAttribute("perturbationType")
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder setPerturbationType(PerturbationType perturbationType) {
			this.perturbationType = perturbationType==null?null:perturbationType.toBuilder();
			return this;
		}
		
		@Override
		public FiniteDifferenceDerivativeParametersModel build() {
			return new FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelImpl(this);
		}
		
		@Override
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder prune() {
			if (perturbationType!=null && !perturbationType.prune().hasData()) perturbationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPerturbationAmount()!=null) return true;
			if (getAveraged()!=null) return true;
			if (getPerturbationType()!=null && getPerturbationType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder o = (FiniteDifferenceDerivativeParametersModel.FiniteDifferenceDerivativeParametersModelBuilder) other;
			
			merger.mergeRosetta(getPerturbationType(), o.getPerturbationType(), this::setPerturbationType);
			
			merger.mergeBasic(getPerturbationAmount(), o.getPerturbationAmount(), this::setPerturbationAmount);
			merger.mergeBasic(getAveraged(), o.getAveraged(), this::setAveraged);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FiniteDifferenceDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(perturbationAmount, _that.getPerturbationAmount())) return false;
			if (!Objects.equals(averaged, _that.getAveraged())) return false;
			if (!Objects.equals(perturbationType, _that.getPerturbationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (perturbationAmount != null ? perturbationAmount.hashCode() : 0);
			_result = 31 * _result + (averaged != null ? averaged.hashCode() : 0);
			_result = 31 * _result + (perturbationType != null ? perturbationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FiniteDifferenceDerivativeParametersModelBuilder {" +
				"perturbationAmount=" + this.perturbationAmount + ", " +
				"averaged=" + this.averaged + ", " +
				"perturbationType=" + this.perturbationType +
			'}';
		}
	}
}
