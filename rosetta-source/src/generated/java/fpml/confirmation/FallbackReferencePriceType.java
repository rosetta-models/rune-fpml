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
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.Empty;
import fpml.confirmation.FallbackReferencePriceType;
import fpml.confirmation.FallbackReferencePriceType.FallbackReferencePriceTypeBuilder;
import fpml.confirmation.FallbackReferencePriceType.FallbackReferencePriceTypeBuilderImpl;
import fpml.confirmation.FallbackReferencePriceType.FallbackReferencePriceTypeImpl;
import fpml.confirmation.SettlementRateOption;
import fpml.confirmation.ValuationPostponementType;
import fpml.confirmation.meta.FallbackReferencePriceTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The method, prioritzed by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 * @version ${project.version}
 */
@RosettaDataType(value="FallbackReferencePriceType", builder=FallbackReferencePriceType.FallbackReferencePriceTypeBuilderImpl.class, version="${project.version}")
public interface FallbackReferencePriceType extends RosettaModelObject {

	FallbackReferencePriceTypeMeta metaData = new FallbackReferencePriceTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption
	 */
	ValuationPostponementType getValuationPostponement();
	/**
	 * This settlement rate option will be used in its place.
	 */
	List<? extends SettlementRateOption> getFallbackSettlementRateOption();
	/**
	 * Request rate quotes from the market.
	 */
	Empty getFallbackSurveyValuationPostponenment();
	/**
	 * The calculation agent will decide the rate.
	 */
	CalculationAgent getCalculationAgentDetermination();

	/*********************** Build Methods  ***********************/
	FallbackReferencePriceType build();
	
	FallbackReferencePriceType.FallbackReferencePriceTypeBuilder toBuilder();
	
	static FallbackReferencePriceType.FallbackReferencePriceTypeBuilder builder() {
		return new FallbackReferencePriceType.FallbackReferencePriceTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackReferencePriceType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FallbackReferencePriceType> getType() {
		return FallbackReferencePriceType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponementType.class, getValuationPostponement());
		processRosetta(path.newSubPath("fallbackSettlementRateOption"), processor, SettlementRateOption.class, getFallbackSettlementRateOption());
		processRosetta(path.newSubPath("fallbackSurveyValuationPostponenment"), processor, Empty.class, getFallbackSurveyValuationPostponenment());
		processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.class, getCalculationAgentDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackReferencePriceTypeBuilder extends FallbackReferencePriceType, RosettaModelObjectBuilder {
		ValuationPostponementType.ValuationPostponementTypeBuilder getOrCreateValuationPostponement();
		ValuationPostponementType.ValuationPostponementTypeBuilder getValuationPostponement();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackSettlementRateOption(int _index);
		List<? extends SettlementRateOption.SettlementRateOptionBuilder> getFallbackSettlementRateOption();
		Empty.EmptyBuilder getOrCreateFallbackSurveyValuationPostponenment();
		Empty.EmptyBuilder getFallbackSurveyValuationPostponenment();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination();
		CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination();
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setValuationPostponement(ValuationPostponementType valuationPostponement);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption0);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption1, int _idx);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOption2);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOption3);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setFallbackSurveyValuationPostponenment(Empty fallbackSurveyValuationPostponenment);
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setCalculationAgentDetermination(CalculationAgent calculationAgentDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponementType.ValuationPostponementTypeBuilder.class, getValuationPostponement());
			processRosetta(path.newSubPath("fallbackSettlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getFallbackSettlementRateOption());
			processRosetta(path.newSubPath("fallbackSurveyValuationPostponenment"), processor, Empty.EmptyBuilder.class, getFallbackSurveyValuationPostponenment());
			processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgentDetermination());
		}
		

		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackReferencePriceType  ***********************/
	class FallbackReferencePriceTypeImpl implements FallbackReferencePriceType {
		private final ValuationPostponementType valuationPostponement;
		private final List<? extends SettlementRateOption> fallbackSettlementRateOption;
		private final Empty fallbackSurveyValuationPostponenment;
		private final CalculationAgent calculationAgentDetermination;
		
		protected FallbackReferencePriceTypeImpl(FallbackReferencePriceType.FallbackReferencePriceTypeBuilder builder) {
			this.valuationPostponement = ofNullable(builder.getValuationPostponement()).map(f->f.build()).orElse(null);
			this.fallbackSettlementRateOption = ofNullable(builder.getFallbackSettlementRateOption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackSurveyValuationPostponenment = ofNullable(builder.getFallbackSurveyValuationPostponenment()).map(f->f.build()).orElse(null);
			this.calculationAgentDetermination = ofNullable(builder.getCalculationAgentDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuationPostponement")
		public ValuationPostponementType getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		@RosettaAttribute("fallbackSettlementRateOption")
		public List<? extends SettlementRateOption> getFallbackSettlementRateOption() {
			return fallbackSettlementRateOption;
		}
		
		@Override
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		public Empty getFallbackSurveyValuationPostponenment() {
			return fallbackSurveyValuationPostponenment;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		public CalculationAgent getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public FallbackReferencePriceType build() {
			return this;
		}
		
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder toBuilder() {
			FallbackReferencePriceType.FallbackReferencePriceTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackReferencePriceType.FallbackReferencePriceTypeBuilder builder) {
			ofNullable(getValuationPostponement()).ifPresent(builder::setValuationPostponement);
			ofNullable(getFallbackSettlementRateOption()).ifPresent(builder::setFallbackSettlementRateOption);
			ofNullable(getFallbackSurveyValuationPostponenment()).ifPresent(builder::setFallbackSurveyValuationPostponenment);
			ofNullable(getCalculationAgentDetermination()).ifPresent(builder::setCalculationAgentDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePriceType _that = getType().cast(o);
		
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			if (!ListEquals.listEquals(fallbackSettlementRateOption, _that.getFallbackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponenment, _that.getFallbackSurveyValuationPostponenment())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			_result = 31 * _result + (fallbackSettlementRateOption != null ? fallbackSettlementRateOption.hashCode() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponenment != null ? fallbackSurveyValuationPostponenment.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePriceType {" +
				"valuationPostponement=" + this.valuationPostponement + ", " +
				"fallbackSettlementRateOption=" + this.fallbackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponenment=" + this.fallbackSurveyValuationPostponenment + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of FallbackReferencePriceType  ***********************/
	class FallbackReferencePriceTypeBuilderImpl implements FallbackReferencePriceType.FallbackReferencePriceTypeBuilder {
	
		protected ValuationPostponementType.ValuationPostponementTypeBuilder valuationPostponement;
		protected List<SettlementRateOption.SettlementRateOptionBuilder> fallbackSettlementRateOption = new ArrayList<>();
		protected Empty.EmptyBuilder fallbackSurveyValuationPostponenment;
		protected CalculationAgent.CalculationAgentBuilder calculationAgentDetermination;
	
		public FallbackReferencePriceTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valuationPostponement")
		public ValuationPostponementType.ValuationPostponementTypeBuilder getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		public ValuationPostponementType.ValuationPostponementTypeBuilder getOrCreateValuationPostponement() {
			ValuationPostponementType.ValuationPostponementTypeBuilder result;
			if (valuationPostponement!=null) {
				result = valuationPostponement;
			}
			else {
				result = valuationPostponement = ValuationPostponementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackSettlementRateOption")
		public List<? extends SettlementRateOption.SettlementRateOptionBuilder> getFallbackSettlementRateOption() {
			return fallbackSettlementRateOption;
		}
		
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackSettlementRateOption(int _index) {
		
			if (fallbackSettlementRateOption==null) {
				this.fallbackSettlementRateOption = new ArrayList<>();
			}
			SettlementRateOption.SettlementRateOptionBuilder result;
			return getIndex(fallbackSettlementRateOption, _index, () -> {
						SettlementRateOption.SettlementRateOptionBuilder newFallbackSettlementRateOption = SettlementRateOption.builder();
						return newFallbackSettlementRateOption;
					});
		}
		
		@Override
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		public Empty.EmptyBuilder getFallbackSurveyValuationPostponenment() {
			return fallbackSurveyValuationPostponenment;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateFallbackSurveyValuationPostponenment() {
			Empty.EmptyBuilder result;
			if (fallbackSurveyValuationPostponenment!=null) {
				result = fallbackSurveyValuationPostponenment;
			}
			else {
				result = fallbackSurveyValuationPostponenment = Empty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgentDetermination!=null) {
				result = calculationAgentDetermination;
			}
			else {
				result = calculationAgentDetermination = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationPostponement")
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setValuationPostponement(ValuationPostponementType valuationPostponement) {
			this.valuationPostponement = valuationPostponement==null?null:valuationPostponement.toBuilder();
			return this;
		}
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption) {
			if (fallbackSettlementRateOption!=null) this.fallbackSettlementRateOption.add(fallbackSettlementRateOption.toBuilder());
			return this;
		}
		
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption, int _idx) {
			getIndex(this.fallbackSettlementRateOption, _idx, () -> fallbackSettlementRateOption.toBuilder());
			return this;
		}
		@Override 
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder addFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOptions) {
			if (fallbackSettlementRateOptions != null) {
				for (SettlementRateOption toAdd : fallbackSettlementRateOptions) {
					this.fallbackSettlementRateOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fallbackSettlementRateOption")
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOptions) {
			if (fallbackSettlementRateOptions == null)  {
				this.fallbackSettlementRateOption = new ArrayList<>();
			}
			else {
				this.fallbackSettlementRateOption = fallbackSettlementRateOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setFallbackSurveyValuationPostponenment(Empty fallbackSurveyValuationPostponenment) {
			this.fallbackSurveyValuationPostponenment = fallbackSurveyValuationPostponenment==null?null:fallbackSurveyValuationPostponenment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder setCalculationAgentDetermination(CalculationAgent calculationAgentDetermination) {
			this.calculationAgentDetermination = calculationAgentDetermination==null?null:calculationAgentDetermination.toBuilder();
			return this;
		}
		
		@Override
		public FallbackReferencePriceType build() {
			return new FallbackReferencePriceType.FallbackReferencePriceTypeImpl(this);
		}
		
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder prune() {
			if (valuationPostponement!=null && !valuationPostponement.prune().hasData()) valuationPostponement = null;
			fallbackSettlementRateOption = fallbackSettlementRateOption.stream().filter(b->b!=null).<SettlementRateOption.SettlementRateOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fallbackSurveyValuationPostponenment!=null && !fallbackSurveyValuationPostponenment.prune().hasData()) fallbackSurveyValuationPostponenment = null;
			if (calculationAgentDetermination!=null && !calculationAgentDetermination.prune().hasData()) calculationAgentDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationPostponement()!=null && getValuationPostponement().hasData()) return true;
			if (getFallbackSettlementRateOption()!=null && getFallbackSettlementRateOption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackSurveyValuationPostponenment()!=null && getFallbackSurveyValuationPostponenment().hasData()) return true;
			if (getCalculationAgentDetermination()!=null && getCalculationAgentDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackReferencePriceType.FallbackReferencePriceTypeBuilder o = (FallbackReferencePriceType.FallbackReferencePriceTypeBuilder) other;
			
			merger.mergeRosetta(getValuationPostponement(), o.getValuationPostponement(), this::setValuationPostponement);
			merger.mergeRosetta(getFallbackSettlementRateOption(), o.getFallbackSettlementRateOption(), this::getOrCreateFallbackSettlementRateOption);
			merger.mergeRosetta(getFallbackSurveyValuationPostponenment(), o.getFallbackSurveyValuationPostponenment(), this::setFallbackSurveyValuationPostponenment);
			merger.mergeRosetta(getCalculationAgentDetermination(), o.getCalculationAgentDetermination(), this::setCalculationAgentDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePriceType _that = getType().cast(o);
		
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			if (!ListEquals.listEquals(fallbackSettlementRateOption, _that.getFallbackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponenment, _that.getFallbackSurveyValuationPostponenment())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			_result = 31 * _result + (fallbackSettlementRateOption != null ? fallbackSettlementRateOption.hashCode() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponenment != null ? fallbackSurveyValuationPostponenment.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePriceTypeBuilder {" +
				"valuationPostponement=" + this.valuationPostponement + ", " +
				"fallbackSettlementRateOption=" + this.fallbackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponenment=" + this.fallbackSurveyValuationPostponenment + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}
}
