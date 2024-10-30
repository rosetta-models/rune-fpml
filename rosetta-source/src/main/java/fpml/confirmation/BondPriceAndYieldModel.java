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
import fpml.confirmation.BondPriceAndYieldModel;
import fpml.confirmation.BondPriceAndYieldModel.BondPriceAndYieldModelBuilder;
import fpml.confirmation.BondPriceAndYieldModel.BondPriceAndYieldModelBuilderImpl;
import fpml.confirmation.BondPriceAndYieldModel.BondPriceAndYieldModelImpl;
import fpml.confirmation.BondPriceAndYieldModelSequence;
import fpml.confirmation.RelativePrice;
import fpml.confirmation.meta.BondPriceAndYieldModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group which has either Bond Price or Yield elements.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BondPriceAndYieldModel", builder=BondPriceAndYieldModel.BondPriceAndYieldModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BondPriceAndYieldModel extends RosettaModelObject {

	BondPriceAndYieldModelMeta metaData = new BondPriceAndYieldModelMeta();

	/*********************** Getter Methods  ***********************/
	BondPriceAndYieldModelSequence getBondPriceAndYieldModelSequence();
	/**
	 * Bond dirty price, expressed in percentage points, 100 is the initial value of the bond.
	 */
	BigDecimal getDirtyPrice();
	/**
	 * Bond price relative to a Benchmark.
	 */
	RelativePrice getRelativePrice();
	/**
	 * Yield to Maturity.
	 */
	BigDecimal getYieldToMaturity();
	/**
	 * The inflation factor is specified for inflation-linked products which require some additional elements to calculate prices correctly.
	 */
	BigDecimal getInflationFactor();
	/**
	 * Bond all-in-price which is a price that includes all relevant price adjustments (i.e. accrued interest, haircut or margin ratio, inflation factor,etc.). It expresses a price in terms of percentage of nominal amount.
	 */
	BigDecimal getAllInPrice();

	/*********************** Build Methods  ***********************/
	BondPriceAndYieldModel build();
	
	BondPriceAndYieldModel.BondPriceAndYieldModelBuilder toBuilder();
	
	static BondPriceAndYieldModel.BondPriceAndYieldModelBuilder builder() {
		return new BondPriceAndYieldModel.BondPriceAndYieldModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondPriceAndYieldModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondPriceAndYieldModel> getType() {
		return BondPriceAndYieldModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bondPriceAndYieldModelSequence"), processor, BondPriceAndYieldModelSequence.class, getBondPriceAndYieldModelSequence());
		processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
		processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.class, getRelativePrice());
		processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
		processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
		processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondPriceAndYieldModelBuilder extends BondPriceAndYieldModel, RosettaModelObjectBuilder {
		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder getOrCreateBondPriceAndYieldModelSequence();
		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder getBondPriceAndYieldModelSequence();
		RelativePrice.RelativePriceBuilder getOrCreateRelativePrice();
		RelativePrice.RelativePriceBuilder getRelativePrice();
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setBondPriceAndYieldModelSequence(BondPriceAndYieldModelSequence bondPriceAndYieldModelSequence);
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setDirtyPrice(BigDecimal dirtyPrice);
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setRelativePrice(RelativePrice relativePrice);
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setYieldToMaturity(BigDecimal yieldToMaturity);
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setInflationFactor(BigDecimal inflationFactor);
		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setAllInPrice(BigDecimal allInPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bondPriceAndYieldModelSequence"), processor, BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder.class, getBondPriceAndYieldModelSequence());
			processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
			processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.RelativePriceBuilder.class, getRelativePrice());
			processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
			processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
			processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
		}
		

		BondPriceAndYieldModel.BondPriceAndYieldModelBuilder prune();
	}

	/*********************** Immutable Implementation of BondPriceAndYieldModel  ***********************/
	class BondPriceAndYieldModelImpl implements BondPriceAndYieldModel {
		private final BondPriceAndYieldModelSequence bondPriceAndYieldModelSequence;
		private final BigDecimal dirtyPrice;
		private final RelativePrice relativePrice;
		private final BigDecimal yieldToMaturity;
		private final BigDecimal inflationFactor;
		private final BigDecimal allInPrice;
		
		protected BondPriceAndYieldModelImpl(BondPriceAndYieldModel.BondPriceAndYieldModelBuilder builder) {
			this.bondPriceAndYieldModelSequence = ofNullable(builder.getBondPriceAndYieldModelSequence()).map(f->f.build()).orElse(null);
			this.dirtyPrice = builder.getDirtyPrice();
			this.relativePrice = ofNullable(builder.getRelativePrice()).map(f->f.build()).orElse(null);
			this.yieldToMaturity = builder.getYieldToMaturity();
			this.inflationFactor = builder.getInflationFactor();
			this.allInPrice = builder.getAllInPrice();
		}
		
		@Override
		@RosettaAttribute("bondPriceAndYieldModelSequence")
		public BondPriceAndYieldModelSequence getBondPriceAndYieldModelSequence() {
			return bondPriceAndYieldModelSequence;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		@RosettaAttribute("relativePrice")
		public RelativePrice getRelativePrice() {
			return relativePrice;
		}
		
		@Override
		@RosettaAttribute("yieldToMaturity")
		public BigDecimal getYieldToMaturity() {
			return yieldToMaturity;
		}
		
		@Override
		@RosettaAttribute("inflationFactor")
		public BigDecimal getInflationFactor() {
			return inflationFactor;
		}
		
		@Override
		@RosettaAttribute("allInPrice")
		public BigDecimal getAllInPrice() {
			return allInPrice;
		}
		
		@Override
		public BondPriceAndYieldModel build() {
			return this;
		}
		
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder toBuilder() {
			BondPriceAndYieldModel.BondPriceAndYieldModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondPriceAndYieldModel.BondPriceAndYieldModelBuilder builder) {
			ofNullable(getBondPriceAndYieldModelSequence()).ifPresent(builder::setBondPriceAndYieldModelSequence);
			ofNullable(getDirtyPrice()).ifPresent(builder::setDirtyPrice);
			ofNullable(getRelativePrice()).ifPresent(builder::setRelativePrice);
			ofNullable(getYieldToMaturity()).ifPresent(builder::setYieldToMaturity);
			ofNullable(getInflationFactor()).ifPresent(builder::setInflationFactor);
			ofNullable(getAllInPrice()).ifPresent(builder::setAllInPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondPriceAndYieldModel _that = getType().cast(o);
		
			if (!Objects.equals(bondPriceAndYieldModelSequence, _that.getBondPriceAndYieldModelSequence())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondPriceAndYieldModelSequence != null ? bondPriceAndYieldModelSequence.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondPriceAndYieldModel {" +
				"bondPriceAndYieldModelSequence=" + this.bondPriceAndYieldModelSequence + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of BondPriceAndYieldModel  ***********************/
	class BondPriceAndYieldModelBuilderImpl implements BondPriceAndYieldModel.BondPriceAndYieldModelBuilder {
	
		protected BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder bondPriceAndYieldModelSequence;
		protected BigDecimal dirtyPrice;
		protected RelativePrice.RelativePriceBuilder relativePrice;
		protected BigDecimal yieldToMaturity;
		protected BigDecimal inflationFactor;
		protected BigDecimal allInPrice;
	
		public BondPriceAndYieldModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bondPriceAndYieldModelSequence")
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder getBondPriceAndYieldModelSequence() {
			return bondPriceAndYieldModelSequence;
		}
		
		@Override
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder getOrCreateBondPriceAndYieldModelSequence() {
			BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder result;
			if (bondPriceAndYieldModelSequence!=null) {
				result = bondPriceAndYieldModelSequence;
			}
			else {
				result = bondPriceAndYieldModelSequence = BondPriceAndYieldModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		@RosettaAttribute("relativePrice")
		public RelativePrice.RelativePriceBuilder getRelativePrice() {
			return relativePrice;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder getOrCreateRelativePrice() {
			RelativePrice.RelativePriceBuilder result;
			if (relativePrice!=null) {
				result = relativePrice;
			}
			else {
				result = relativePrice = RelativePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("yieldToMaturity")
		public BigDecimal getYieldToMaturity() {
			return yieldToMaturity;
		}
		
		@Override
		@RosettaAttribute("inflationFactor")
		public BigDecimal getInflationFactor() {
			return inflationFactor;
		}
		
		@Override
		@RosettaAttribute("allInPrice")
		public BigDecimal getAllInPrice() {
			return allInPrice;
		}
		
		@Override
		@RosettaAttribute("bondPriceAndYieldModelSequence")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setBondPriceAndYieldModelSequence(BondPriceAndYieldModelSequence bondPriceAndYieldModelSequence) {
			this.bondPriceAndYieldModelSequence = bondPriceAndYieldModelSequence==null?null:bondPriceAndYieldModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dirtyPrice")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setDirtyPrice(BigDecimal dirtyPrice) {
			this.dirtyPrice = dirtyPrice==null?null:dirtyPrice;
			return this;
		}
		@Override
		@RosettaAttribute("relativePrice")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setRelativePrice(RelativePrice relativePrice) {
			this.relativePrice = relativePrice==null?null:relativePrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("yieldToMaturity")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setYieldToMaturity(BigDecimal yieldToMaturity) {
			this.yieldToMaturity = yieldToMaturity==null?null:yieldToMaturity;
			return this;
		}
		@Override
		@RosettaAttribute("inflationFactor")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setInflationFactor(BigDecimal inflationFactor) {
			this.inflationFactor = inflationFactor==null?null:inflationFactor;
			return this;
		}
		@Override
		@RosettaAttribute("allInPrice")
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder setAllInPrice(BigDecimal allInPrice) {
			this.allInPrice = allInPrice==null?null:allInPrice;
			return this;
		}
		
		@Override
		public BondPriceAndYieldModel build() {
			return new BondPriceAndYieldModel.BondPriceAndYieldModelImpl(this);
		}
		
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder prune() {
			if (bondPriceAndYieldModelSequence!=null && !bondPriceAndYieldModelSequence.prune().hasData()) bondPriceAndYieldModelSequence = null;
			if (relativePrice!=null && !relativePrice.prune().hasData()) relativePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondPriceAndYieldModelSequence()!=null && getBondPriceAndYieldModelSequence().hasData()) return true;
			if (getDirtyPrice()!=null) return true;
			if (getRelativePrice()!=null && getRelativePrice().hasData()) return true;
			if (getYieldToMaturity()!=null) return true;
			if (getInflationFactor()!=null) return true;
			if (getAllInPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondPriceAndYieldModel.BondPriceAndYieldModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondPriceAndYieldModel.BondPriceAndYieldModelBuilder o = (BondPriceAndYieldModel.BondPriceAndYieldModelBuilder) other;
			
			merger.mergeRosetta(getBondPriceAndYieldModelSequence(), o.getBondPriceAndYieldModelSequence(), this::setBondPriceAndYieldModelSequence);
			merger.mergeRosetta(getRelativePrice(), o.getRelativePrice(), this::setRelativePrice);
			
			merger.mergeBasic(getDirtyPrice(), o.getDirtyPrice(), this::setDirtyPrice);
			merger.mergeBasic(getYieldToMaturity(), o.getYieldToMaturity(), this::setYieldToMaturity);
			merger.mergeBasic(getInflationFactor(), o.getInflationFactor(), this::setInflationFactor);
			merger.mergeBasic(getAllInPrice(), o.getAllInPrice(), this::setAllInPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondPriceAndYieldModel _that = getType().cast(o);
		
			if (!Objects.equals(bondPriceAndYieldModelSequence, _that.getBondPriceAndYieldModelSequence())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondPriceAndYieldModelSequence != null ? bondPriceAndYieldModelSequence.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondPriceAndYieldModelBuilder {" +
				"bondPriceAndYieldModelSequence=" + this.bondPriceAndYieldModelSequence + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice +
			'}';
		}
	}
}
