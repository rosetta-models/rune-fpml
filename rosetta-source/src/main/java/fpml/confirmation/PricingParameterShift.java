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
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PricingParameterShift;
import fpml.confirmation.PricingParameterShift.PricingParameterShiftBuilder;
import fpml.confirmation.PricingParameterShift.PricingParameterShiftBuilderImpl;
import fpml.confirmation.PricingParameterShift.PricingParameterShiftImpl;
import fpml.confirmation.meta.PricingParameterShiftMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A definition of a shift with respect to a specific pricing parameter.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingParameterShift", builder=PricingParameterShift.PricingParameterShiftBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingParameterShift extends RosettaModelObject {

	PricingParameterShiftMeta metaData = new PricingParameterShiftMeta();

	/*********************** Getter Methods  ***********************/
	AssetOrTermPointOrPricingStructureReference getParameterReference();
	/**
	 * The size of the denominator, e.g. 0.0001 = 1 bp.
	 */
	BigDecimal getShift();
	/**
	 * The units of the denominator, e.g. currency. If not present, use the units of the PricingInputReference.
	 */
	PriceQuoteUnits getShiftUnits();
	String getId();

	/*********************** Build Methods  ***********************/
	PricingParameterShift build();
	
	PricingParameterShift.PricingParameterShiftBuilder toBuilder();
	
	static PricingParameterShift.PricingParameterShiftBuilder builder() {
		return new PricingParameterShift.PricingParameterShiftBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingParameterShift> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingParameterShift> getType() {
		return PricingParameterShift.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.class, getParameterReference());
		processor.processBasic(path.newSubPath("shift"), BigDecimal.class, getShift(), this);
		processRosetta(path.newSubPath("shiftUnits"), processor, PriceQuoteUnits.class, getShiftUnits());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingParameterShiftBuilder extends PricingParameterShift, RosettaModelObjectBuilder {
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference();
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateShiftUnits();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getShiftUnits();
		PricingParameterShift.PricingParameterShiftBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference);
		PricingParameterShift.PricingParameterShiftBuilder setShift(BigDecimal shift);
		PricingParameterShift.PricingParameterShiftBuilder setShiftUnits(PriceQuoteUnits shiftUnits);
		PricingParameterShift.PricingParameterShiftBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder.class, getParameterReference());
			processor.processBasic(path.newSubPath("shift"), BigDecimal.class, getShift(), this);
			processRosetta(path.newSubPath("shiftUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getShiftUnits());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PricingParameterShift.PricingParameterShiftBuilder prune();
	}

	/*********************** Immutable Implementation of PricingParameterShift  ***********************/
	class PricingParameterShiftImpl implements PricingParameterShift {
		private final AssetOrTermPointOrPricingStructureReference parameterReference;
		private final BigDecimal shift;
		private final PriceQuoteUnits shiftUnits;
		private final String id;
		
		protected PricingParameterShiftImpl(PricingParameterShift.PricingParameterShiftBuilder builder) {
			this.parameterReference = ofNullable(builder.getParameterReference()).map(f->f.build()).orElse(null);
			this.shift = builder.getShift();
			this.shiftUnits = ofNullable(builder.getShiftUnits()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference getParameterReference() {
			return parameterReference;
		}
		
		@Override
		@RosettaAttribute("shift")
		public BigDecimal getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("shiftUnits")
		public PriceQuoteUnits getShiftUnits() {
			return shiftUnits;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PricingParameterShift build() {
			return this;
		}
		
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder toBuilder() {
			PricingParameterShift.PricingParameterShiftBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingParameterShift.PricingParameterShiftBuilder builder) {
			ofNullable(getParameterReference()).ifPresent(builder::setParameterReference);
			ofNullable(getShift()).ifPresent(builder::setShift);
			ofNullable(getShiftUnits()).ifPresent(builder::setShiftUnits);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterShift _that = getType().cast(o);
		
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(shift, _that.getShift())) return false;
			if (!Objects.equals(shiftUnits, _that.getShiftUnits())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (shiftUnits != null ? shiftUnits.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterShift {" +
				"parameterReference=" + this.parameterReference + ", " +
				"shift=" + this.shift + ", " +
				"shiftUnits=" + this.shiftUnits + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingParameterShift  ***********************/
	class PricingParameterShiftBuilderImpl implements PricingParameterShift.PricingParameterShiftBuilder {
	
		protected AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder parameterReference;
		protected BigDecimal shift;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder shiftUnits;
		protected String id;
	
		public PricingParameterShiftBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference() {
			return parameterReference;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference() {
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder result;
			if (parameterReference!=null) {
				result = parameterReference;
			}
			else {
				result = parameterReference = AssetOrTermPointOrPricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("shift")
		public BigDecimal getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("shiftUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getShiftUnits() {
			return shiftUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateShiftUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (shiftUnits!=null) {
				result = shiftUnits;
			}
			else {
				result = shiftUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		public PricingParameterShift.PricingParameterShiftBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference) {
			this.parameterReference = parameterReference==null?null:parameterReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("shift")
		public PricingParameterShift.PricingParameterShiftBuilder setShift(BigDecimal shift) {
			this.shift = shift==null?null:shift;
			return this;
		}
		@Override
		@RosettaAttribute("shiftUnits")
		public PricingParameterShift.PricingParameterShiftBuilder setShiftUnits(PriceQuoteUnits shiftUnits) {
			this.shiftUnits = shiftUnits==null?null:shiftUnits.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PricingParameterShift.PricingParameterShiftBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PricingParameterShift build() {
			return new PricingParameterShift.PricingParameterShiftImpl(this);
		}
		
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder prune() {
			if (parameterReference!=null && !parameterReference.prune().hasData()) parameterReference = null;
			if (shiftUnits!=null && !shiftUnits.prune().hasData()) shiftUnits = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParameterReference()!=null && getParameterReference().hasData()) return true;
			if (getShift()!=null) return true;
			if (getShiftUnits()!=null && getShiftUnits().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingParameterShift.PricingParameterShiftBuilder o = (PricingParameterShift.PricingParameterShiftBuilder) other;
			
			merger.mergeRosetta(getParameterReference(), o.getParameterReference(), this::setParameterReference);
			merger.mergeRosetta(getShiftUnits(), o.getShiftUnits(), this::setShiftUnits);
			
			merger.mergeBasic(getShift(), o.getShift(), this::setShift);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterShift _that = getType().cast(o);
		
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(shift, _that.getShift())) return false;
			if (!Objects.equals(shiftUnits, _that.getShiftUnits())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (shiftUnits != null ? shiftUnits.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterShiftBuilder {" +
				"parameterReference=" + this.parameterReference + ", " +
				"shift=" + this.shift + ", " +
				"shiftUnits=" + this.shiftUnits + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
