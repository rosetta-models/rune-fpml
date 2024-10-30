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
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder;
import fpml.confirmation.CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilderImpl;
import fpml.confirmation.CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceImpl;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.SettlementPeriodsFixedPrice;
import fpml.confirmation.meta.CommodityFixedPriceModelChoiceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityFixedPriceModelChoice", builder=CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityFixedPriceModelChoice extends RosettaModelObject {

	CommodityFixedPriceModelChoiceMeta metaData = new CommodityFixedPriceModelChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fixed price on which fixed payments are based.
	 */
	FixedPrice getFixedPrice();
	/**
	 * For a WET Voyager Charter Commodity Swap, the number of Worldscale Points for purposes of the calculation of a Fixed Amount.
	 */
	BigDecimal getWorldscaleRate();
	/**
	 * For a DRY Voyage Charter or Time Charter Commodity Swap, the price per relevant unit for pruposes of the calculation of a Fixed Amount.
	 */
	NonNegativeMoney getContractRate();
	/**
	 * For an electricity transaction, the fixed price for one or more groups of Settlement Periods on which fixed payments are based. If the fixed price differs for different groups of Settlement Periods, this element should be repeated.
	 */
	List<? extends SettlementPeriodsFixedPrice> getSettlementPeriodsPrice();

	/*********************** Build Methods  ***********************/
	CommodityFixedPriceModelChoice build();
	
	CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder toBuilder();
	
	static CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder builder() {
		return new CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPriceModelChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFixedPriceModelChoice> getType() {
		return CommodityFixedPriceModelChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.class, getFixedPrice());
		processor.processBasic(path.newSubPath("worldscaleRate"), BigDecimal.class, getWorldscaleRate(), this);
		processRosetta(path.newSubPath("contractRate"), processor, NonNegativeMoney.class, getContractRate());
		processRosetta(path.newSubPath("settlementPeriodsPrice"), processor, SettlementPeriodsFixedPrice.class, getSettlementPeriodsPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPriceModelChoiceBuilder extends CommodityFixedPriceModelChoice, RosettaModelObjectBuilder {
		FixedPrice.FixedPriceBuilder getOrCreateFixedPrice();
		FixedPrice.FixedPriceBuilder getFixedPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRate();
		NonNegativeMoney.NonNegativeMoneyBuilder getContractRate();
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder getOrCreateSettlementPeriodsPrice(int _index);
		List<? extends SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder> getSettlementPeriodsPrice();
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setFixedPrice(FixedPrice fixedPrice);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setWorldscaleRate(BigDecimal worldscaleRate);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setContractRate(NonNegativeMoney contractRate);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice0);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice1, int _idx);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrice2);
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrice3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.FixedPriceBuilder.class, getFixedPrice());
			processor.processBasic(path.newSubPath("worldscaleRate"), BigDecimal.class, getWorldscaleRate(), this);
			processRosetta(path.newSubPath("contractRate"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getContractRate());
			processRosetta(path.newSubPath("settlementPeriodsPrice"), processor, SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder.class, getSettlementPeriodsPrice());
		}
		

		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPriceModelChoice  ***********************/
	class CommodityFixedPriceModelChoiceImpl implements CommodityFixedPriceModelChoice {
		private final FixedPrice fixedPrice;
		private final BigDecimal worldscaleRate;
		private final NonNegativeMoney contractRate;
		private final List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrice;
		
		protected CommodityFixedPriceModelChoiceImpl(CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder builder) {
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.worldscaleRate = builder.getWorldscaleRate();
			this.contractRate = ofNullable(builder.getContractRate()).map(f->f.build()).orElse(null);
			this.settlementPeriodsPrice = ofNullable(builder.getSettlementPeriodsPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		public FixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("worldscaleRate")
		public BigDecimal getWorldscaleRate() {
			return worldscaleRate;
		}
		
		@Override
		@RosettaAttribute("contractRate")
		public NonNegativeMoney getContractRate() {
			return contractRate;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPrice")
		public List<? extends SettlementPeriodsFixedPrice> getSettlementPeriodsPrice() {
			return settlementPeriodsPrice;
		}
		
		@Override
		public CommodityFixedPriceModelChoice build() {
			return this;
		}
		
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder toBuilder() {
			CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder builder) {
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getWorldscaleRate()).ifPresent(builder::setWorldscaleRate);
			ofNullable(getContractRate()).ifPresent(builder::setContractRate);
			ofNullable(getSettlementPeriodsPrice()).ifPresent(builder::setSettlementPeriodsPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceModelChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(worldscaleRate, _that.getWorldscaleRate())) return false;
			if (!Objects.equals(contractRate, _that.getContractRate())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPrice, _that.getSettlementPeriodsPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (worldscaleRate != null ? worldscaleRate.hashCode() : 0);
			_result = 31 * _result + (contractRate != null ? contractRate.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPrice != null ? settlementPeriodsPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceModelChoice {" +
				"fixedPrice=" + this.fixedPrice + ", " +
				"worldscaleRate=" + this.worldscaleRate + ", " +
				"contractRate=" + this.contractRate + ", " +
				"settlementPeriodsPrice=" + this.settlementPeriodsPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPriceModelChoice  ***********************/
	class CommodityFixedPriceModelChoiceBuilderImpl implements CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder {
	
		protected FixedPrice.FixedPriceBuilder fixedPrice;
		protected BigDecimal worldscaleRate;
		protected NonNegativeMoney.NonNegativeMoneyBuilder contractRate;
		protected List<SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder> settlementPeriodsPrice = new ArrayList<>();
	
		public CommodityFixedPriceModelChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedPrice")
		public FixedPrice.FixedPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder getOrCreateFixedPrice() {
			FixedPrice.FixedPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = FixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("worldscaleRate")
		public BigDecimal getWorldscaleRate() {
			return worldscaleRate;
		}
		
		@Override
		@RosettaAttribute("contractRate")
		public NonNegativeMoney.NonNegativeMoneyBuilder getContractRate() {
			return contractRate;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRate() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (contractRate!=null) {
				result = contractRate;
			}
			else {
				result = contractRate = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPrice")
		public List<? extends SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder> getSettlementPeriodsPrice() {
			return settlementPeriodsPrice;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder getOrCreateSettlementPeriodsPrice(int _index) {
		
			if (settlementPeriodsPrice==null) {
				this.settlementPeriodsPrice = new ArrayList<>();
			}
			SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder result;
			return getIndex(settlementPeriodsPrice, _index, () -> {
						SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder newSettlementPeriodsPrice = SettlementPeriodsFixedPrice.builder();
						return newSettlementPeriodsPrice;
					});
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setFixedPrice(FixedPrice fixedPrice) {
			this.fixedPrice = fixedPrice==null?null:fixedPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("worldscaleRate")
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setWorldscaleRate(BigDecimal worldscaleRate) {
			this.worldscaleRate = worldscaleRate==null?null:worldscaleRate;
			return this;
		}
		@Override
		@RosettaAttribute("contractRate")
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setContractRate(NonNegativeMoney contractRate) {
			this.contractRate = contractRate==null?null:contractRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodsPrice")
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice) {
			if (settlementPeriodsPrice!=null) this.settlementPeriodsPrice.add(settlementPeriodsPrice.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice, int _idx) {
			getIndex(this.settlementPeriodsPrice, _idx, () -> settlementPeriodsPrice.toBuilder());
			return this;
		}
		@Override 
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder addSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrices) {
			if (settlementPeriodsPrices != null) {
				for (SettlementPeriodsFixedPrice toAdd : settlementPeriodsPrices) {
					this.settlementPeriodsPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder setSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrices) {
			if (settlementPeriodsPrices == null)  {
				this.settlementPeriodsPrice = new ArrayList<>();
			}
			else {
				this.settlementPeriodsPrice = settlementPeriodsPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CommodityFixedPriceModelChoice build() {
			return new CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceImpl(this);
		}
		
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder prune() {
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (contractRate!=null && !contractRate.prune().hasData()) contractRate = null;
			settlementPeriodsPrice = settlementPeriodsPrice.stream().filter(b->b!=null).<SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getWorldscaleRate()!=null) return true;
			if (getContractRate()!=null && getContractRate().hasData()) return true;
			if (getSettlementPeriodsPrice()!=null && getSettlementPeriodsPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder o = (CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder) other;
			
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getContractRate(), o.getContractRate(), this::setContractRate);
			merger.mergeRosetta(getSettlementPeriodsPrice(), o.getSettlementPeriodsPrice(), this::getOrCreateSettlementPeriodsPrice);
			
			merger.mergeBasic(getWorldscaleRate(), o.getWorldscaleRate(), this::setWorldscaleRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceModelChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(worldscaleRate, _that.getWorldscaleRate())) return false;
			if (!Objects.equals(contractRate, _that.getContractRate())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPrice, _that.getSettlementPeriodsPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (worldscaleRate != null ? worldscaleRate.hashCode() : 0);
			_result = 31 * _result + (contractRate != null ? contractRate.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPrice != null ? settlementPeriodsPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceModelChoiceBuilder {" +
				"fixedPrice=" + this.fixedPrice + ", " +
				"worldscaleRate=" + this.worldscaleRate + ", " +
				"contractRate=" + this.contractRate + ", " +
				"settlementPeriodsPrice=" + this.settlementPeriodsPrice +
			'}';
		}
	}
}
