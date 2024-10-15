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
import fpml.confirmation.BondPriceAndYieldModelSequence;
import fpml.confirmation.BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder;
import fpml.confirmation.BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilderImpl;
import fpml.confirmation.BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceImpl;
import fpml.confirmation.meta.BondPriceAndYieldModelSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BondPriceAndYieldModelSequence", builder=BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilderImpl.class, version="${project.version}")
public interface BondPriceAndYieldModelSequence extends RosettaModelObject {

	BondPriceAndYieldModelSequenceMeta metaData = new BondPriceAndYieldModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Bond clean price, expressed in percentage points, 100 is the initial value of the bond.
	 */
	BigDecimal getCleanPrice();
	/**
	 * Accruals, relationship is clean price and accruals equals dirty price, all prices are expressed in percentage points, 100 is the initial value of the bond.
	 */
	BigDecimal getAccruals();
	/**
	 * Bond dirty price, expressed in percentage points, 100 is the initial value of the bond.
	 */
	BigDecimal getDirtyPrice();

	/*********************** Build Methods  ***********************/
	BondPriceAndYieldModelSequence build();
	
	BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder toBuilder();
	
	static BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder builder() {
		return new BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondPriceAndYieldModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondPriceAndYieldModelSequence> getType() {
		return BondPriceAndYieldModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
		processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
		processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondPriceAndYieldModelSequenceBuilder extends BondPriceAndYieldModelSequence, RosettaModelObjectBuilder {
		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setCleanPrice(BigDecimal cleanPrice);
		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setAccruals(BigDecimal accruals);
		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setDirtyPrice(BigDecimal dirtyPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
			processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
			processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
		}
		

		BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of BondPriceAndYieldModelSequence  ***********************/
	class BondPriceAndYieldModelSequenceImpl implements BondPriceAndYieldModelSequence {
		private final BigDecimal cleanPrice;
		private final BigDecimal accruals;
		private final BigDecimal dirtyPrice;
		
		protected BondPriceAndYieldModelSequenceImpl(BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder builder) {
			this.cleanPrice = builder.getCleanPrice();
			this.accruals = builder.getAccruals();
			this.dirtyPrice = builder.getDirtyPrice();
		}
		
		@Override
		@RosettaAttribute("cleanPrice")
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		@RosettaAttribute("accruals")
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		public BondPriceAndYieldModelSequence build() {
			return this;
		}
		
		@Override
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder toBuilder() {
			BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder builder) {
			ofNullable(getCleanPrice()).ifPresent(builder::setCleanPrice);
			ofNullable(getAccruals()).ifPresent(builder::setAccruals);
			ofNullable(getDirtyPrice()).ifPresent(builder::setDirtyPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondPriceAndYieldModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondPriceAndYieldModelSequence {" +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of BondPriceAndYieldModelSequence  ***********************/
	class BondPriceAndYieldModelSequenceBuilderImpl implements BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder {
	
		protected BigDecimal cleanPrice;
		protected BigDecimal accruals;
		protected BigDecimal dirtyPrice;
	
		public BondPriceAndYieldModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cleanPrice")
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		@RosettaAttribute("accruals")
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		@RosettaAttribute("cleanPrice")
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setCleanPrice(BigDecimal cleanPrice) {
			this.cleanPrice = cleanPrice==null?null:cleanPrice;
			return this;
		}
		@Override
		@RosettaAttribute("accruals")
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setAccruals(BigDecimal accruals) {
			this.accruals = accruals==null?null:accruals;
			return this;
		}
		@Override
		@RosettaAttribute("dirtyPrice")
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder setDirtyPrice(BigDecimal dirtyPrice) {
			this.dirtyPrice = dirtyPrice==null?null:dirtyPrice;
			return this;
		}
		
		@Override
		public BondPriceAndYieldModelSequence build() {
			return new BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceImpl(this);
		}
		
		@Override
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCleanPrice()!=null) return true;
			if (getAccruals()!=null) return true;
			if (getDirtyPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder o = (BondPriceAndYieldModelSequence.BondPriceAndYieldModelSequenceBuilder) other;
			
			
			merger.mergeBasic(getCleanPrice(), o.getCleanPrice(), this::setCleanPrice);
			merger.mergeBasic(getAccruals(), o.getAccruals(), this::setAccruals);
			merger.mergeBasic(getDirtyPrice(), o.getDirtyPrice(), this::setDirtyPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondPriceAndYieldModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondPriceAndYieldModelSequenceBuilder {" +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice +
			'}';
		}
	}
}
