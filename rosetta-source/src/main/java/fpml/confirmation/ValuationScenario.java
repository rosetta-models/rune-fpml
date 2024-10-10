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
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.MarketReference;
import fpml.confirmation.PricingInputReplacement;
import fpml.confirmation.PricingParameterShift;
import fpml.confirmation.ValuationScenario;
import fpml.confirmation.ValuationScenario.ValuationScenarioBuilder;
import fpml.confirmation.ValuationScenario.ValuationScenarioBuilderImpl;
import fpml.confirmation.ValuationScenario.ValuationScenarioImpl;
import fpml.confirmation.meta.ValuationScenarioMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of rules for generating a valuation.
 * @version ${project.version}
 */
@RosettaDataType(value="ValuationScenario", builder=ValuationScenario.ValuationScenarioBuilderImpl.class, version="${project.version}")
public interface ValuationScenario extends RosettaModelObject {

	ValuationScenarioMeta metaData = new ValuationScenarioMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The (optional) name for this valuation scenario, used for understandability. For example &quot;EOD Valuations&quot;.
	 */
	String getName();
	/**
	 * The date for which the assets are valued.
	 */
	IdentifiedDate getValuationDate();
	/**
	 * A reference to the market environment used to price the asset.
	 */
	MarketReference getMarketReference();
	/**
	 * A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 */
	List<? extends PricingParameterShift> getShift();
	/**
	 * A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 */
	List<? extends PricingInputReplacement> getReplacement();
	String getId();

	/*********************** Build Methods  ***********************/
	ValuationScenario build();
	
	ValuationScenario.ValuationScenarioBuilder toBuilder();
	
	static ValuationScenario.ValuationScenarioBuilder builder() {
		return new ValuationScenario.ValuationScenarioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationScenario> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationScenario> getType() {
		return ValuationScenario.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationDate"), processor, IdentifiedDate.class, getValuationDate());
		processRosetta(path.newSubPath("marketReference"), processor, MarketReference.class, getMarketReference());
		processRosetta(path.newSubPath("shift"), processor, PricingParameterShift.class, getShift());
		processRosetta(path.newSubPath("replacement"), processor, PricingInputReplacement.class, getReplacement());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationScenarioBuilder extends ValuationScenario, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateValuationDate();
		IdentifiedDate.IdentifiedDateBuilder getValuationDate();
		MarketReference.MarketReferenceBuilder getOrCreateMarketReference();
		MarketReference.MarketReferenceBuilder getMarketReference();
		PricingParameterShift.PricingParameterShiftBuilder getOrCreateShift(int _index);
		List<? extends PricingParameterShift.PricingParameterShiftBuilder> getShift();
		PricingInputReplacement.PricingInputReplacementBuilder getOrCreateReplacement(int _index);
		List<? extends PricingInputReplacement.PricingInputReplacementBuilder> getReplacement();
		ValuationScenario.ValuationScenarioBuilder setName(String name);
		ValuationScenario.ValuationScenarioBuilder setValuationDate(IdentifiedDate valuationDate);
		ValuationScenario.ValuationScenarioBuilder setMarketReference(MarketReference marketReference);
		ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift0);
		ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift1, int _idx);
		ValuationScenario.ValuationScenarioBuilder addShift(List<? extends PricingParameterShift> shift2);
		ValuationScenario.ValuationScenarioBuilder setShift(List<? extends PricingParameterShift> shift3);
		ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement0);
		ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement1, int _idx);
		ValuationScenario.ValuationScenarioBuilder addReplacement(List<? extends PricingInputReplacement> replacement2);
		ValuationScenario.ValuationScenarioBuilder setReplacement(List<? extends PricingInputReplacement> replacement3);
		ValuationScenario.ValuationScenarioBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("marketReference"), processor, MarketReference.MarketReferenceBuilder.class, getMarketReference());
			processRosetta(path.newSubPath("shift"), processor, PricingParameterShift.PricingParameterShiftBuilder.class, getShift());
			processRosetta(path.newSubPath("replacement"), processor, PricingInputReplacement.PricingInputReplacementBuilder.class, getReplacement());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ValuationScenario.ValuationScenarioBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationScenario  ***********************/
	class ValuationScenarioImpl implements ValuationScenario {
		private final String name;
		private final IdentifiedDate valuationDate;
		private final MarketReference marketReference;
		private final List<? extends PricingParameterShift> shift;
		private final List<? extends PricingInputReplacement> replacement;
		private final String id;
		
		protected ValuationScenarioImpl(ValuationScenario.ValuationScenarioBuilder builder) {
			this.name = builder.getName();
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.marketReference = ofNullable(builder.getMarketReference()).map(f->f.build()).orElse(null);
			this.shift = ofNullable(builder.getShift()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.replacement = ofNullable(builder.getReplacement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public IdentifiedDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("marketReference")
		public MarketReference getMarketReference() {
			return marketReference;
		}
		
		@Override
		@RosettaAttribute("shift")
		public List<? extends PricingParameterShift> getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("replacement")
		public List<? extends PricingInputReplacement> getReplacement() {
			return replacement;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ValuationScenario build() {
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder toBuilder() {
			ValuationScenario.ValuationScenarioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationScenario.ValuationScenarioBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getMarketReference()).ifPresent(builder::setMarketReference);
			ofNullable(getShift()).ifPresent(builder::setShift);
			ofNullable(getReplacement()).ifPresent(builder::setReplacement);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationScenario _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(marketReference, _that.getMarketReference())) return false;
			if (!ListEquals.listEquals(shift, _that.getShift())) return false;
			if (!ListEquals.listEquals(replacement, _that.getReplacement())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (marketReference != null ? marketReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (replacement != null ? replacement.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationScenario {" +
				"name=" + this.name + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"marketReference=" + this.marketReference + ", " +
				"shift=" + this.shift + ", " +
				"replacement=" + this.replacement + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationScenario  ***********************/
	class ValuationScenarioBuilderImpl implements ValuationScenario.ValuationScenarioBuilder {
	
		protected String name;
		protected IdentifiedDate.IdentifiedDateBuilder valuationDate;
		protected MarketReference.MarketReferenceBuilder marketReference;
		protected List<PricingParameterShift.PricingParameterShiftBuilder> shift = new ArrayList<>();
		protected List<PricingInputReplacement.PricingInputReplacementBuilder> replacement = new ArrayList<>();
		protected String id;
	
		public ValuationScenarioBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public IdentifiedDate.IdentifiedDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateValuationDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketReference")
		public MarketReference.MarketReferenceBuilder getMarketReference() {
			return marketReference;
		}
		
		@Override
		public MarketReference.MarketReferenceBuilder getOrCreateMarketReference() {
			MarketReference.MarketReferenceBuilder result;
			if (marketReference!=null) {
				result = marketReference;
			}
			else {
				result = marketReference = MarketReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("shift")
		public List<? extends PricingParameterShift.PricingParameterShiftBuilder> getShift() {
			return shift;
		}
		
		public PricingParameterShift.PricingParameterShiftBuilder getOrCreateShift(int _index) {
		
			if (shift==null) {
				this.shift = new ArrayList<>();
			}
			PricingParameterShift.PricingParameterShiftBuilder result;
			return getIndex(shift, _index, () -> {
						PricingParameterShift.PricingParameterShiftBuilder newShift = PricingParameterShift.builder();
						return newShift;
					});
		}
		
		@Override
		@RosettaAttribute("replacement")
		public List<? extends PricingInputReplacement.PricingInputReplacementBuilder> getReplacement() {
			return replacement;
		}
		
		public PricingInputReplacement.PricingInputReplacementBuilder getOrCreateReplacement(int _index) {
		
			if (replacement==null) {
				this.replacement = new ArrayList<>();
			}
			PricingInputReplacement.PricingInputReplacementBuilder result;
			return getIndex(replacement, _index, () -> {
						PricingInputReplacement.PricingInputReplacementBuilder newReplacement = PricingInputReplacement.builder();
						return newReplacement;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public ValuationScenario.ValuationScenarioBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public ValuationScenario.ValuationScenarioBuilder setValuationDate(IdentifiedDate valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("marketReference")
		public ValuationScenario.ValuationScenarioBuilder setMarketReference(MarketReference marketReference) {
			this.marketReference = marketReference==null?null:marketReference.toBuilder();
			return this;
		}
		@Override
		public ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift) {
			if (shift!=null) this.shift.add(shift.toBuilder());
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift, int _idx) {
			getIndex(this.shift, _idx, () -> shift.toBuilder());
			return this;
		}
		@Override 
		public ValuationScenario.ValuationScenarioBuilder addShift(List<? extends PricingParameterShift> shifts) {
			if (shifts != null) {
				for (PricingParameterShift toAdd : shifts) {
					this.shift.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("shift")
		public ValuationScenario.ValuationScenarioBuilder setShift(List<? extends PricingParameterShift> shifts) {
			if (shifts == null)  {
				this.shift = new ArrayList<>();
			}
			else {
				this.shift = shifts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement) {
			if (replacement!=null) this.replacement.add(replacement.toBuilder());
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement, int _idx) {
			getIndex(this.replacement, _idx, () -> replacement.toBuilder());
			return this;
		}
		@Override 
		public ValuationScenario.ValuationScenarioBuilder addReplacement(List<? extends PricingInputReplacement> replacements) {
			if (replacements != null) {
				for (PricingInputReplacement toAdd : replacements) {
					this.replacement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("replacement")
		public ValuationScenario.ValuationScenarioBuilder setReplacement(List<? extends PricingInputReplacement> replacements) {
			if (replacements == null)  {
				this.replacement = new ArrayList<>();
			}
			else {
				this.replacement = replacements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public ValuationScenario.ValuationScenarioBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ValuationScenario build() {
			return new ValuationScenario.ValuationScenarioImpl(this);
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationScenario.ValuationScenarioBuilder prune() {
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (marketReference!=null && !marketReference.prune().hasData()) marketReference = null;
			shift = shift.stream().filter(b->b!=null).<PricingParameterShift.PricingParameterShiftBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			replacement = replacement.stream().filter(b->b!=null).<PricingInputReplacement.PricingInputReplacementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getMarketReference()!=null && getMarketReference().hasData()) return true;
			if (getShift()!=null && getShift().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReplacement()!=null && getReplacement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationScenario.ValuationScenarioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationScenario.ValuationScenarioBuilder o = (ValuationScenario.ValuationScenarioBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getMarketReference(), o.getMarketReference(), this::setMarketReference);
			merger.mergeRosetta(getShift(), o.getShift(), this::getOrCreateShift);
			merger.mergeRosetta(getReplacement(), o.getReplacement(), this::getOrCreateReplacement);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationScenario _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(marketReference, _that.getMarketReference())) return false;
			if (!ListEquals.listEquals(shift, _that.getShift())) return false;
			if (!ListEquals.listEquals(replacement, _that.getReplacement())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (marketReference != null ? marketReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (replacement != null ? replacement.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationScenarioBuilder {" +
				"name=" + this.name + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"marketReference=" + this.marketReference + ", " +
				"shift=" + this.shift + ", " +
				"replacement=" + this.replacement + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
