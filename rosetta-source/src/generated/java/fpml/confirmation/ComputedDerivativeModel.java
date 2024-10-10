package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.ComputedDerivativeModel.ComputedDerivativeModelBuilder;
import fpml.confirmation.ComputedDerivativeModel.ComputedDerivativeModelBuilderImpl;
import fpml.confirmation.ComputedDerivativeModel.ComputedDerivativeModelImpl;
import fpml.confirmation.DerivativeFormula;
import fpml.confirmation.PricingParameterDerivative;
import fpml.confirmation.meta.ComputedDerivativeModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ComputedDerivativeModel", builder=ComputedDerivativeModel.ComputedDerivativeModelBuilderImpl.class, version="${project.version}")
public interface ComputedDerivativeModel extends RosettaModelObject {

	ComputedDerivativeModelMeta metaData = new ComputedDerivativeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A partial derivative of the measure with respect to an input.
	 */
	List<? extends PricingParameterDerivative> getPartialDerivative();
	/**
	 * A formula defining how to compute the derivative from the partial derivatives. If absent, the derivative is just the product of the partial derivatives. Normally only required for more higher-order derivatives, e.g. Hessians.
	 */
	DerivativeFormula getFormula();

	/*********************** Build Methods  ***********************/
	ComputedDerivativeModel build();
	
	ComputedDerivativeModel.ComputedDerivativeModelBuilder toBuilder();
	
	static ComputedDerivativeModel.ComputedDerivativeModelBuilder builder() {
		return new ComputedDerivativeModel.ComputedDerivativeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ComputedDerivativeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ComputedDerivativeModel> getType() {
		return ComputedDerivativeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialDerivative"), processor, PricingParameterDerivative.class, getPartialDerivative());
		processRosetta(path.newSubPath("formula"), processor, DerivativeFormula.class, getFormula());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ComputedDerivativeModelBuilder extends ComputedDerivativeModel, RosettaModelObjectBuilder {
		PricingParameterDerivative.PricingParameterDerivativeBuilder getOrCreatePartialDerivative(int _index);
		List<? extends PricingParameterDerivative.PricingParameterDerivativeBuilder> getPartialDerivative();
		DerivativeFormula.DerivativeFormulaBuilder getOrCreateFormula();
		DerivativeFormula.DerivativeFormulaBuilder getFormula();
		ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(PricingParameterDerivative partialDerivative0);
		ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(PricingParameterDerivative partialDerivative1, int _idx);
		ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(List<? extends PricingParameterDerivative> partialDerivative2);
		ComputedDerivativeModel.ComputedDerivativeModelBuilder setPartialDerivative(List<? extends PricingParameterDerivative> partialDerivative3);
		ComputedDerivativeModel.ComputedDerivativeModelBuilder setFormula(DerivativeFormula formula);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialDerivative"), processor, PricingParameterDerivative.PricingParameterDerivativeBuilder.class, getPartialDerivative());
			processRosetta(path.newSubPath("formula"), processor, DerivativeFormula.DerivativeFormulaBuilder.class, getFormula());
		}
		

		ComputedDerivativeModel.ComputedDerivativeModelBuilder prune();
	}

	/*********************** Immutable Implementation of ComputedDerivativeModel  ***********************/
	class ComputedDerivativeModelImpl implements ComputedDerivativeModel {
		private final List<? extends PricingParameterDerivative> partialDerivative;
		private final DerivativeFormula formula;
		
		protected ComputedDerivativeModelImpl(ComputedDerivativeModel.ComputedDerivativeModelBuilder builder) {
			this.partialDerivative = ofNullable(builder.getPartialDerivative()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partialDerivative")
		public List<? extends PricingParameterDerivative> getPartialDerivative() {
			return partialDerivative;
		}
		
		@Override
		@RosettaAttribute("formula")
		public DerivativeFormula getFormula() {
			return formula;
		}
		
		@Override
		public ComputedDerivativeModel build() {
			return this;
		}
		
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder toBuilder() {
			ComputedDerivativeModel.ComputedDerivativeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ComputedDerivativeModel.ComputedDerivativeModelBuilder builder) {
			ofNullable(getPartialDerivative()).ifPresent(builder::setPartialDerivative);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ComputedDerivativeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partialDerivative, _that.getPartialDerivative())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivative != null ? partialDerivative.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ComputedDerivativeModel {" +
				"partialDerivative=" + this.partialDerivative + ", " +
				"formula=" + this.formula +
			'}';
		}
	}

	/*********************** Builder Implementation of ComputedDerivativeModel  ***********************/
	class ComputedDerivativeModelBuilderImpl implements ComputedDerivativeModel.ComputedDerivativeModelBuilder {
	
		protected List<PricingParameterDerivative.PricingParameterDerivativeBuilder> partialDerivative = new ArrayList<>();
		protected DerivativeFormula.DerivativeFormulaBuilder formula;
	
		public ComputedDerivativeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partialDerivative")
		public List<? extends PricingParameterDerivative.PricingParameterDerivativeBuilder> getPartialDerivative() {
			return partialDerivative;
		}
		
		public PricingParameterDerivative.PricingParameterDerivativeBuilder getOrCreatePartialDerivative(int _index) {
		
			if (partialDerivative==null) {
				this.partialDerivative = new ArrayList<>();
			}
			PricingParameterDerivative.PricingParameterDerivativeBuilder result;
			return getIndex(partialDerivative, _index, () -> {
						PricingParameterDerivative.PricingParameterDerivativeBuilder newPartialDerivative = PricingParameterDerivative.builder();
						return newPartialDerivative;
					});
		}
		
		@Override
		@RosettaAttribute("formula")
		public DerivativeFormula.DerivativeFormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder getOrCreateFormula() {
			DerivativeFormula.DerivativeFormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = DerivativeFormula.builder();
			}
			
			return result;
		}
		
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(PricingParameterDerivative partialDerivative) {
			if (partialDerivative!=null) this.partialDerivative.add(partialDerivative.toBuilder());
			return this;
		}
		
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(PricingParameterDerivative partialDerivative, int _idx) {
			getIndex(this.partialDerivative, _idx, () -> partialDerivative.toBuilder());
			return this;
		}
		@Override 
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder addPartialDerivative(List<? extends PricingParameterDerivative> partialDerivatives) {
			if (partialDerivatives != null) {
				for (PricingParameterDerivative toAdd : partialDerivatives) {
					this.partialDerivative.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partialDerivative")
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder setPartialDerivative(List<? extends PricingParameterDerivative> partialDerivatives) {
			if (partialDerivatives == null)  {
				this.partialDerivative = new ArrayList<>();
			}
			else {
				this.partialDerivative = partialDerivatives.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("formula")
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder setFormula(DerivativeFormula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		
		@Override
		public ComputedDerivativeModel build() {
			return new ComputedDerivativeModel.ComputedDerivativeModelImpl(this);
		}
		
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder prune() {
			partialDerivative = partialDerivative.stream().filter(b->b!=null).<PricingParameterDerivative.PricingParameterDerivativeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (formula!=null && !formula.prune().hasData()) formula = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartialDerivative()!=null && getPartialDerivative().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ComputedDerivativeModel.ComputedDerivativeModelBuilder o = (ComputedDerivativeModel.ComputedDerivativeModelBuilder) other;
			
			merger.mergeRosetta(getPartialDerivative(), o.getPartialDerivative(), this::getOrCreatePartialDerivative);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ComputedDerivativeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partialDerivative, _that.getPartialDerivative())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivative != null ? partialDerivative.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ComputedDerivativeModelBuilder {" +
				"partialDerivative=" + this.partialDerivative + ", " +
				"formula=" + this.formula +
			'}';
		}
	}
}
