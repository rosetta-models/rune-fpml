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
import fpml.confirmation.AmountReference;
import fpml.confirmation.FxConversion;
import fpml.confirmation.FxConversion.FxConversionBuilder;
import fpml.confirmation.FxConversion.FxConversionBuilderImpl;
import fpml.confirmation.FxConversion.FxConversionImpl;
import fpml.confirmation.FxRate;
import fpml.confirmation.meta.FxConversionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxConversion", builder=FxConversion.FxConversionBuilderImpl.class, version="${project.version}")
public interface FxConversion extends RosettaModelObject {

	FxConversionMeta metaData = new FxConversionMeta();

	/*********************** Getter Methods  ***********************/
	AmountReference getAmountRelativeTo();
	/**
	 * Specifies a currency conversion rate.
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	FxConversion build();
	
	FxConversion.FxConversionBuilder toBuilder();
	
	static FxConversion.FxConversionBuilder builder() {
		return new FxConversion.FxConversionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxConversion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxConversion> getType() {
		return FxConversion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxConversionBuilder extends FxConversion, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		FxRate.FxRateBuilder getOrCreateFxRate(int _index);
		List<? extends FxRate.FxRateBuilder> getFxRate();
		FxConversion.FxConversionBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		FxConversion.FxConversionBuilder addFxRate(FxRate fxRate0);
		FxConversion.FxConversionBuilder addFxRate(FxRate fxRate1, int _idx);
		FxConversion.FxConversionBuilder addFxRate(List<? extends FxRate> fxRate2);
		FxConversion.FxConversionBuilder setFxRate(List<? extends FxRate> fxRate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		FxConversion.FxConversionBuilder prune();
	}

	/*********************** Immutable Implementation of FxConversion  ***********************/
	class FxConversionImpl implements FxConversion {
		private final AmountReference amountRelativeTo;
		private final List<? extends FxRate> fxRate;
		
		protected FxConversionImpl(FxConversion.FxConversionBuilder builder) {
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxConversion build() {
			return this;
		}
		
		@Override
		public FxConversion.FxConversionBuilder toBuilder() {
			FxConversion.FxConversionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxConversion.FxConversionBuilder builder) {
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxConversion _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxConversion {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxConversion  ***********************/
	class FxConversionBuilderImpl implements FxConversion.FxConversionBuilder {
	
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
	
		public FxConversionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
		public FxRate.FxRateBuilder getOrCreateFxRate(int _index) {
		
			if (fxRate==null) {
				this.fxRate = new ArrayList<>();
			}
			FxRate.FxRateBuilder result;
			return getIndex(fxRate, _index, () -> {
						FxRate.FxRateBuilder newFxRate = FxRate.builder();
						return newFxRate;
					});
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public FxConversion.FxConversionBuilder setAmountRelativeTo(AmountReference amountRelativeTo) {
			this.amountRelativeTo = amountRelativeTo==null?null:amountRelativeTo.toBuilder();
			return this;
		}
		@Override
		public FxConversion.FxConversionBuilder addFxRate(FxRate fxRate) {
			if (fxRate!=null) this.fxRate.add(fxRate.toBuilder());
			return this;
		}
		
		@Override
		public FxConversion.FxConversionBuilder addFxRate(FxRate fxRate, int _idx) {
			getIndex(this.fxRate, _idx, () -> fxRate.toBuilder());
			return this;
		}
		@Override 
		public FxConversion.FxConversionBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fxRate")
		public FxConversion.FxConversionBuilder setFxRate(List<? extends FxRate> fxRates) {
			if (fxRates == null)  {
				this.fxRate = new ArrayList<>();
			}
			else {
				this.fxRate = fxRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxConversion build() {
			return new FxConversion.FxConversionImpl(this);
		}
		
		@Override
		public FxConversion.FxConversionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxConversion.FxConversionBuilder prune() {
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxConversion.FxConversionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxConversion.FxConversionBuilder o = (FxConversion.FxConversionBuilder) other;
			
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxConversion _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxConversionBuilder {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}
}
