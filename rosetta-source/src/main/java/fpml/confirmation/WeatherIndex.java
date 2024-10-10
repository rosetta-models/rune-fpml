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
import fpml.confirmation.WeatherIndex;
import fpml.confirmation.WeatherIndex.WeatherIndexBuilder;
import fpml.confirmation.WeatherIndex.WeatherIndexBuilderImpl;
import fpml.confirmation.WeatherIndex.WeatherIndexImpl;
import fpml.confirmation.meta.WeatherIndexMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the Weather Index Level or Weather Index Strike Level.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherIndex", builder=WeatherIndex.WeatherIndexBuilderImpl.class, version="${project.version}")
public interface WeatherIndex extends RosettaModelObject {

	WeatherIndexMeta metaData = new WeatherIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This is the Reference Level. The CDD, HDD or HDD Reference Level is specified as the number of (amount of) Weather Index Units specified by the parties in the related Confirmation.
	 */
	BigDecimal getQuantity();
	/**
	 * Weather Index Unit derived from one of the following variable methods of determination: Cooling Degree Day (CDD), Heating Degree Day (HDD), Critical Precipitation Day (CPD) as defined in Section 11.15 of the 2005 ISDA Commodity Definitions and User Guide.
	 */
	QuantityUnit getUnit();
	String getId();

	/*********************** Build Methods  ***********************/
	WeatherIndex build();
	
	WeatherIndex.WeatherIndexBuilder toBuilder();
	
	static WeatherIndex.WeatherIndexBuilder builder() {
		return new WeatherIndex.WeatherIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherIndex> getType() {
		return WeatherIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("unit"), processor, QuantityUnit.class, getUnit());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherIndexBuilder extends WeatherIndex, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateUnit();
		QuantityUnit.QuantityUnitBuilder getUnit();
		WeatherIndex.WeatherIndexBuilder setQuantity(BigDecimal quantity);
		WeatherIndex.WeatherIndexBuilder setUnit(QuantityUnit unit);
		WeatherIndex.WeatherIndexBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("unit"), processor, QuantityUnit.QuantityUnitBuilder.class, getUnit());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherIndex.WeatherIndexBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherIndex  ***********************/
	class WeatherIndexImpl implements WeatherIndex {
		private final BigDecimal quantity;
		private final QuantityUnit unit;
		private final String id;
		
		protected WeatherIndexImpl(WeatherIndex.WeatherIndexBuilder builder) {
			this.quantity = builder.getQuantity();
			this.unit = ofNullable(builder.getUnit()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherIndex build() {
			return this;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder toBuilder() {
			WeatherIndex.WeatherIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherIndex.WeatherIndexBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndex _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndex {" +
				"quantity=" + this.quantity + ", " +
				"unit=" + this.unit + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherIndex  ***********************/
	class WeatherIndexBuilderImpl implements WeatherIndex.WeatherIndexBuilder {
	
		protected BigDecimal quantity;
		protected QuantityUnit.QuantityUnitBuilder unit;
		protected String id;
	
		public WeatherIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit.QuantityUnitBuilder getUnit() {
			return unit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (unit!=null) {
				result = unit;
			}
			else {
				result = unit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public WeatherIndex.WeatherIndexBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("unit")
		public WeatherIndex.WeatherIndexBuilder setUnit(QuantityUnit unit) {
			this.unit = unit==null?null:unit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public WeatherIndex.WeatherIndexBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public WeatherIndex build() {
			return new WeatherIndex.WeatherIndexImpl(this);
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndex.WeatherIndexBuilder prune() {
			if (unit!=null && !unit.prune().hasData()) unit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantity()!=null) return true;
			if (getUnit()!=null && getUnit().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndex.WeatherIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherIndex.WeatherIndexBuilder o = (WeatherIndex.WeatherIndexBuilder) other;
			
			merger.mergeRosetta(getUnit(), o.getUnit(), this::setUnit);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndex _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexBuilder {" +
				"quantity=" + this.quantity + ", " +
				"unit=" + this.unit + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
