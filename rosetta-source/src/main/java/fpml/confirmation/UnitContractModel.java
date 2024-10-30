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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.UnitContractModel;
import fpml.confirmation.UnitContractModel.UnitContractModelBuilder;
import fpml.confirmation.UnitContractModel.UnitContractModelBuilderImpl;
import fpml.confirmation.UnitContractModel.UnitContractModelImpl;
import fpml.confirmation.meta.UnitContractModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group which has unit based trade elements (copied from FpML Extensions 2.2 - fpmlext-repo.xsd).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UnitContractModel", builder=UnitContractModel.UnitContractModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UnitContractModel extends RosettaModelObject {

	UnitContractModelMeta metaData = new UnitContractModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of units (index or securities).
	 */
	BigDecimal getNumberOfUnits();
	/**
	 * The price of each unit.
	 */
	NonNegativeMoney getUnitPrice();

	/*********************** Build Methods  ***********************/
	UnitContractModel build();
	
	UnitContractModel.UnitContractModelBuilder toBuilder();
	
	static UnitContractModel.UnitContractModelBuilder builder() {
		return new UnitContractModel.UnitContractModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnitContractModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnitContractModel> getType() {
		return UnitContractModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
		processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.class, getUnitPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitContractModelBuilder extends UnitContractModel, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateUnitPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getUnitPrice();
		UnitContractModel.UnitContractModelBuilder setNumberOfUnits(BigDecimal numberOfUnits);
		UnitContractModel.UnitContractModelBuilder setUnitPrice(NonNegativeMoney unitPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
			processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getUnitPrice());
		}
		

		UnitContractModel.UnitContractModelBuilder prune();
	}

	/*********************** Immutable Implementation of UnitContractModel  ***********************/
	class UnitContractModelImpl implements UnitContractModel {
		private final BigDecimal numberOfUnits;
		private final NonNegativeMoney unitPrice;
		
		protected UnitContractModelImpl(UnitContractModel.UnitContractModelBuilder builder) {
			this.numberOfUnits = builder.getNumberOfUnits();
			this.unitPrice = ofNullable(builder.getUnitPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitPrice")
		public NonNegativeMoney getUnitPrice() {
			return unitPrice;
		}
		
		@Override
		public UnitContractModel build() {
			return this;
		}
		
		@Override
		public UnitContractModel.UnitContractModelBuilder toBuilder() {
			UnitContractModel.UnitContractModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitContractModel.UnitContractModelBuilder builder) {
			ofNullable(getNumberOfUnits()).ifPresent(builder::setNumberOfUnits);
			ofNullable(getUnitPrice()).ifPresent(builder::setUnitPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitContractModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitContractModel {" +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitPrice=" + this.unitPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of UnitContractModel  ***********************/
	class UnitContractModelBuilderImpl implements UnitContractModel.UnitContractModelBuilder {
	
		protected BigDecimal numberOfUnits;
		protected NonNegativeMoney.NonNegativeMoneyBuilder unitPrice;
	
		public UnitContractModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getUnitPrice() {
			return unitPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateUnitPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (unitPrice!=null) {
				result = unitPrice;
			}
			else {
				result = unitPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		public UnitContractModel.UnitContractModelBuilder setNumberOfUnits(BigDecimal numberOfUnits) {
			this.numberOfUnits = numberOfUnits==null?null:numberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("unitPrice")
		public UnitContractModel.UnitContractModelBuilder setUnitPrice(NonNegativeMoney unitPrice) {
			this.unitPrice = unitPrice==null?null:unitPrice.toBuilder();
			return this;
		}
		
		@Override
		public UnitContractModel build() {
			return new UnitContractModel.UnitContractModelImpl(this);
		}
		
		@Override
		public UnitContractModel.UnitContractModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitContractModel.UnitContractModelBuilder prune() {
			if (unitPrice!=null && !unitPrice.prune().hasData()) unitPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfUnits()!=null) return true;
			if (getUnitPrice()!=null && getUnitPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitContractModel.UnitContractModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnitContractModel.UnitContractModelBuilder o = (UnitContractModel.UnitContractModelBuilder) other;
			
			merger.mergeRosetta(getUnitPrice(), o.getUnitPrice(), this::setUnitPrice);
			
			merger.mergeBasic(getNumberOfUnits(), o.getNumberOfUnits(), this::setNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitContractModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitContractModelBuilder {" +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitPrice=" + this.unitPrice +
			'}';
		}
	}
}
