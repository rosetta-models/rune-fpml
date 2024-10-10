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
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.UnitQuantity;
import fpml.confirmation.UnitQuantity.UnitQuantityBuilder;
import fpml.confirmation.UnitQuantity.UnitQuantityBuilderImpl;
import fpml.confirmation.UnitQuantity.UnitQuantityImpl;
import fpml.confirmation.meta.UnitQuantityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A quantity and associated unit.
 * @version ${project.version}
 */
@RosettaDataType(value="UnitQuantity", builder=UnitQuantity.UnitQuantityBuilderImpl.class, version="${project.version}")
public interface UnitQuantity extends RosettaModelObject {

	UnitQuantityMeta metaData = new UnitQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Quantity Unit is the unit of measure applicable for the quantity on the Transaction.
	 */
	QuantityUnit getQuantityUnit();
	/**
	 * Amount of commodity per quantity frequency.
	 */
	BigDecimal getQuantity();
	String getId();

	/*********************** Build Methods  ***********************/
	UnitQuantity build();
	
	UnitQuantity.UnitQuantityBuilder toBuilder();
	
	static UnitQuantity.UnitQuantityBuilder builder() {
		return new UnitQuantity.UnitQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnitQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnitQuantity> getType() {
		return UnitQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitQuantityBuilder extends UnitQuantity, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit();
		QuantityUnit.QuantityUnitBuilder getQuantityUnit();
		UnitQuantity.UnitQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		UnitQuantity.UnitQuantityBuilder setQuantity(BigDecimal quantity);
		UnitQuantity.UnitQuantityBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		UnitQuantity.UnitQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of UnitQuantity  ***********************/
	class UnitQuantityImpl implements UnitQuantity {
		private final QuantityUnit quantityUnit;
		private final BigDecimal quantity;
		private final String id;
		
		protected UnitQuantityImpl(UnitQuantity.UnitQuantityBuilder builder) {
			this.quantityUnit = ofNullable(builder.getQuantityUnit()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		public QuantityUnit getQuantityUnit() {
			return quantityUnit;
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
		public UnitQuantity build() {
			return this;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder toBuilder() {
			UnitQuantity.UnitQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitQuantity.UnitQuantityBuilder builder) {
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitQuantity _that = getType().cast(o);
		
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantity {" +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantity=" + this.quantity + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of UnitQuantity  ***********************/
	class UnitQuantityBuilderImpl implements UnitQuantity.UnitQuantityBuilder {
	
		protected QuantityUnit.QuantityUnitBuilder quantityUnit;
		protected BigDecimal quantity;
		protected String id;
	
		public UnitQuantityBuilderImpl() {
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
		public UnitQuantity.UnitQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit) {
			this.quantityUnit = quantityUnit==null?null:quantityUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public UnitQuantity.UnitQuantityBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public UnitQuantity.UnitQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public UnitQuantity build() {
			return new UnitQuantity.UnitQuantityImpl(this);
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantity.UnitQuantityBuilder prune() {
			if (quantityUnit!=null && !quantityUnit.prune().hasData()) quantityUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantityUnit()!=null && getQuantityUnit().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantity.UnitQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnitQuantity.UnitQuantityBuilder o = (UnitQuantity.UnitQuantityBuilder) other;
			
			merger.mergeRosetta(getQuantityUnit(), o.getQuantityUnit(), this::setQuantityUnit);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitQuantity _that = getType().cast(o);
		
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityBuilder {" +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantity=" + this.quantity + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
