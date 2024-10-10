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
import fpml.confirmation.ProblemLocation;
import fpml.confirmation.ProblemLocation.ProblemLocationBuilder;
import fpml.confirmation.ProblemLocation.ProblemLocationBuilderImpl;
import fpml.confirmation.ProblemLocation.ProblemLocationImpl;
import fpml.confirmation.meta.ProblemLocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides a lexical location (i.e. a line number and character for bad XML) or an XPath location (i.e. place to identify the bad location for valid XML).
 * @version ${project.version}
 */
@RosettaDataType(value="ProblemLocation", builder=ProblemLocation.ProblemLocationBuilderImpl.class, version="${project.version}")
public interface ProblemLocation extends RosettaModelObject {

	ProblemLocationMeta metaData = new ProblemLocationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The value of the locationType attribute defines which type of location has been given. It may take the values &#39;lexical&#39; or &#39;xpath&#39;.
	 */
	String getLocationType();

	/*********************** Build Methods  ***********************/
	ProblemLocation build();
	
	ProblemLocation.ProblemLocationBuilder toBuilder();
	
	static ProblemLocation.ProblemLocationBuilder builder() {
		return new ProblemLocation.ProblemLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProblemLocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProblemLocation> getType() {
		return ProblemLocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("locationType"), String.class, getLocationType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProblemLocationBuilder extends ProblemLocation, RosettaModelObjectBuilder {
		ProblemLocation.ProblemLocationBuilder setValue(String value);
		ProblemLocation.ProblemLocationBuilder setLocationType(String locationType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("locationType"), String.class, getLocationType(), this);
		}
		

		ProblemLocation.ProblemLocationBuilder prune();
	}

	/*********************** Immutable Implementation of ProblemLocation  ***********************/
	class ProblemLocationImpl implements ProblemLocation {
		private final String value;
		private final String locationType;
		
		protected ProblemLocationImpl(ProblemLocation.ProblemLocationBuilder builder) {
			this.value = builder.getValue();
			this.locationType = builder.getLocationType();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("locationType")
		public String getLocationType() {
			return locationType;
		}
		
		@Override
		public ProblemLocation build() {
			return this;
		}
		
		@Override
		public ProblemLocation.ProblemLocationBuilder toBuilder() {
			ProblemLocation.ProblemLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProblemLocation.ProblemLocationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLocationType()).ifPresent(builder::setLocationType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProblemLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(locationType, _that.getLocationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (locationType != null ? locationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProblemLocation {" +
				"value=" + this.value + ", " +
				"locationType=" + this.locationType +
			'}';
		}
	}

	/*********************** Builder Implementation of ProblemLocation  ***********************/
	class ProblemLocationBuilderImpl implements ProblemLocation.ProblemLocationBuilder {
	
		protected String value;
		protected String locationType;
	
		public ProblemLocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("locationType")
		public String getLocationType() {
			return locationType;
		}
		
		@Override
		@RosettaAttribute("value")
		public ProblemLocation.ProblemLocationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("locationType")
		public ProblemLocation.ProblemLocationBuilder setLocationType(String locationType) {
			this.locationType = locationType==null?null:locationType;
			return this;
		}
		
		@Override
		public ProblemLocation build() {
			return new ProblemLocation.ProblemLocationImpl(this);
		}
		
		@Override
		public ProblemLocation.ProblemLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProblemLocation.ProblemLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLocationType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProblemLocation.ProblemLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProblemLocation.ProblemLocationBuilder o = (ProblemLocation.ProblemLocationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLocationType(), o.getLocationType(), this::setLocationType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProblemLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(locationType, _that.getLocationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (locationType != null ? locationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProblemLocationBuilder {" +
				"value=" + this.value + ", " +
				"locationType=" + this.locationType +
			'}';
		}
	}
}
