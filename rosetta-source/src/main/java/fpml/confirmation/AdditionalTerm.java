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
import fpml.confirmation.AdditionalTerm;
import fpml.confirmation.AdditionalTerm.AdditionalTermBuilder;
import fpml.confirmation.AdditionalTerm.AdditionalTermBuilderImpl;
import fpml.confirmation.AdditionalTerm.AdditionalTermImpl;
import fpml.confirmation.meta.AdditionalTermMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AdditionalTerm", builder=AdditionalTerm.AdditionalTermBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AdditionalTerm extends RosettaModelObject {

	AdditionalTermMeta metaData = new AdditionalTermMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAdditionalTermScheme();

	/*********************** Build Methods  ***********************/
	AdditionalTerm build();
	
	AdditionalTerm.AdditionalTermBuilder toBuilder();
	
	static AdditionalTerm.AdditionalTermBuilder builder() {
		return new AdditionalTerm.AdditionalTermBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalTerm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdditionalTerm> getType() {
		return AdditionalTerm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("additionalTermScheme"), String.class, getAdditionalTermScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalTermBuilder extends AdditionalTerm, RosettaModelObjectBuilder {
		AdditionalTerm.AdditionalTermBuilder setValue(String value);
		AdditionalTerm.AdditionalTermBuilder setAdditionalTermScheme(String additionalTermScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("additionalTermScheme"), String.class, getAdditionalTermScheme(), this);
		}
		

		AdditionalTerm.AdditionalTermBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalTerm  ***********************/
	class AdditionalTermImpl implements AdditionalTerm {
		private final String value;
		private final String additionalTermScheme;
		
		protected AdditionalTermImpl(AdditionalTerm.AdditionalTermBuilder builder) {
			this.value = builder.getValue();
			this.additionalTermScheme = builder.getAdditionalTermScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("additionalTermScheme")
		public String getAdditionalTermScheme() {
			return additionalTermScheme;
		}
		
		@Override
		public AdditionalTerm build() {
			return this;
		}
		
		@Override
		public AdditionalTerm.AdditionalTermBuilder toBuilder() {
			AdditionalTerm.AdditionalTermBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalTerm.AdditionalTermBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAdditionalTermScheme()).ifPresent(builder::setAdditionalTermScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerm _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(additionalTermScheme, _that.getAdditionalTermScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (additionalTermScheme != null ? additionalTermScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTerm {" +
				"value=" + this.value + ", " +
				"additionalTermScheme=" + this.additionalTermScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalTerm  ***********************/
	class AdditionalTermBuilderImpl implements AdditionalTerm.AdditionalTermBuilder {
	
		protected String value;
		protected String additionalTermScheme;
	
		public AdditionalTermBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("additionalTermScheme")
		public String getAdditionalTermScheme() {
			return additionalTermScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AdditionalTerm.AdditionalTermBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("additionalTermScheme")
		public AdditionalTerm.AdditionalTermBuilder setAdditionalTermScheme(String additionalTermScheme) {
			this.additionalTermScheme = additionalTermScheme==null?null:additionalTermScheme;
			return this;
		}
		
		@Override
		public AdditionalTerm build() {
			return new AdditionalTerm.AdditionalTermImpl(this);
		}
		
		@Override
		public AdditionalTerm.AdditionalTermBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerm.AdditionalTermBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAdditionalTermScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerm.AdditionalTermBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalTerm.AdditionalTermBuilder o = (AdditionalTerm.AdditionalTermBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAdditionalTermScheme(), o.getAdditionalTermScheme(), this::setAdditionalTermScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerm _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(additionalTermScheme, _that.getAdditionalTermScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (additionalTermScheme != null ? additionalTermScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTermBuilder {" +
				"value=" + this.value + ", " +
				"additionalTermScheme=" + this.additionalTermScheme +
			'}';
		}
	}
}
