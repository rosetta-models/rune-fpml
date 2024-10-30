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
import fpml.confirmation.Region;
import fpml.confirmation.Region.RegionBuilder;
import fpml.confirmation.Region.RegionBuilderImpl;
import fpml.confirmation.Region.RegionImpl;
import fpml.confirmation.meta.RegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A code that describes the world region of a counterparty. For example, NorthAmerica, Europe, Asia.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Region", builder=Region.RegionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Region extends RosettaModelObject {

	RegionMeta metaData = new RegionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRegionScheme();

	/*********************** Build Methods  ***********************/
	Region build();
	
	Region.RegionBuilder toBuilder();
	
	static Region.RegionBuilder builder() {
		return new Region.RegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Region> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Region> getType() {
		return Region.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("regionScheme"), String.class, getRegionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegionBuilder extends Region, RosettaModelObjectBuilder {
		Region.RegionBuilder setValue(String value);
		Region.RegionBuilder setRegionScheme(String regionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("regionScheme"), String.class, getRegionScheme(), this);
		}
		

		Region.RegionBuilder prune();
	}

	/*********************** Immutable Implementation of Region  ***********************/
	class RegionImpl implements Region {
		private final String value;
		private final String regionScheme;
		
		protected RegionImpl(Region.RegionBuilder builder) {
			this.value = builder.getValue();
			this.regionScheme = builder.getRegionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regionScheme")
		public String getRegionScheme() {
			return regionScheme;
		}
		
		@Override
		public Region build() {
			return this;
		}
		
		@Override
		public Region.RegionBuilder toBuilder() {
			Region.RegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Region.RegionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRegionScheme()).ifPresent(builder::setRegionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Region _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regionScheme, _that.getRegionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regionScheme != null ? regionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Region {" +
				"value=" + this.value + ", " +
				"regionScheme=" + this.regionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Region  ***********************/
	class RegionBuilderImpl implements Region.RegionBuilder {
	
		protected String value;
		protected String regionScheme;
	
		public RegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regionScheme")
		public String getRegionScheme() {
			return regionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Region.RegionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("regionScheme")
		public Region.RegionBuilder setRegionScheme(String regionScheme) {
			this.regionScheme = regionScheme==null?null:regionScheme;
			return this;
		}
		
		@Override
		public Region build() {
			return new Region.RegionImpl(this);
		}
		
		@Override
		public Region.RegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Region.RegionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRegionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Region.RegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Region.RegionBuilder o = (Region.RegionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRegionScheme(), o.getRegionScheme(), this::setRegionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Region _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regionScheme, _that.getRegionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regionScheme != null ? regionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegionBuilder {" +
				"value=" + this.value + ", " +
				"regionScheme=" + this.regionScheme +
			'}';
		}
	}
}
