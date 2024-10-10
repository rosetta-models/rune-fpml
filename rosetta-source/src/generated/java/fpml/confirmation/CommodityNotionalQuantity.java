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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityBuilder;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityImpl;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.CommodityNotionalQuantityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Commodity Notional.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityNotionalQuantity", builder=CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl.class, version="${project.version}")
public interface CommodityNotionalQuantity extends RosettaModelObject {

	CommodityNotionalQuantityMeta metaData = new CommodityNotionalQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Quantity Unit is the unit of measure applicable for the quantity on the Transaction.
	 */
	QuantityUnit getQuantityUnit();
	/**
	 * The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 */
	CommodityQuantityFrequency getQuantityFrequency();
	/**
	 * Amount of commodity per quantity frequency.
	 */
	BigDecimal getQuantity();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityNotionalQuantity build();
	
	CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder();
	
	static CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder() {
		return new CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalQuantity> getType() {
		return CommodityNotionalQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityBuilder extends CommodityNotionalQuantity, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit();
		QuantityUnit.QuantityUnitBuilder getQuantityUnit();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantity(BigDecimal quantity);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantity  ***********************/
	class CommodityNotionalQuantityImpl implements CommodityNotionalQuantity {
		private final QuantityUnit quantityUnit;
		private final CommodityQuantityFrequency quantityFrequency;
		private final BigDecimal quantity;
		private final String id;
		
		protected CommodityNotionalQuantityImpl(CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder) {
			this.quantityUnit = ofNullable(builder.getQuantityUnit()).map(f->f.build()).orElse(null);
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		public QuantityUnit getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommodityQuantityFrequency getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityNotionalQuantity build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder) {
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantity {" +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantity=" + this.quantity + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantity  ***********************/
	class CommodityNotionalQuantityBuilderImpl implements CommodityNotionalQuantity.CommodityNotionalQuantityBuilder {
	
		protected QuantityUnit.QuantityUnitBuilder quantityUnit;
		protected CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder quantityFrequency;
		protected BigDecimal quantity;
		protected String id;
	
		public CommodityNotionalQuantityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quantityUnit")
		public QuantityUnit.QuantityUnitBuilder getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (quantityUnit!=null) {
				result = quantityUnit;
			}
			else {
				result = quantityUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder result;
			if (quantityFrequency!=null) {
				result = quantityFrequency;
			}
			else {
				result = quantityFrequency = CommodityQuantityFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit) {
			this.quantityUnit = quantityUnit==null?null:quantityUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency) {
			this.quantityFrequency = quantityFrequency==null?null:quantityFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityNotionalQuantity build() {
			return new CommodityNotionalQuantity.CommodityNotionalQuantityImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder prune() {
			if (quantityUnit!=null && !quantityUnit.prune().hasData()) quantityUnit = null;
			if (quantityFrequency!=null && !quantityFrequency.prune().hasData()) quantityFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantityUnit()!=null && getQuantityUnit().hasData()) return true;
			if (getQuantityFrequency()!=null && getQuantityFrequency().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder o = (CommodityNotionalQuantity.CommodityNotionalQuantityBuilder) other;
			
			merger.mergeRosetta(getQuantityUnit(), o.getQuantityUnit(), this::setQuantityUnit);
			merger.mergeRosetta(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityBuilder {" +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantity=" + this.quantity + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
