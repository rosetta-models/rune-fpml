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
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.InterconnectionPoint.InterconnectionPointBuilder;
import fpml.confirmation.InterconnectionPoint.InterconnectionPointBuilderImpl;
import fpml.confirmation.InterconnectionPoint.InterconnectionPointImpl;
import fpml.confirmation.meta.InterconnectionPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identification of the border(s) or border point(s) of a transportation contract. Use the list of EIC codes for timelines for electricity (T Codes) or the list of EIC codes for measurement points for gas (Z Codes).
 * @version ${project.version}
 */
@RosettaDataType(value="InterconnectionPoint", builder=InterconnectionPoint.InterconnectionPointBuilderImpl.class, version="${project.version}")
public interface InterconnectionPoint extends RosettaModelObject {

	InterconnectionPointMeta metaData = new InterconnectionPointMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getInterconnectionPointScheme();

	/*********************** Build Methods  ***********************/
	InterconnectionPoint build();
	
	InterconnectionPoint.InterconnectionPointBuilder toBuilder();
	
	static InterconnectionPoint.InterconnectionPointBuilder builder() {
		return new InterconnectionPoint.InterconnectionPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterconnectionPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterconnectionPoint> getType() {
		return InterconnectionPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("interconnectionPointScheme"), String.class, getInterconnectionPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterconnectionPointBuilder extends InterconnectionPoint, RosettaModelObjectBuilder {
		InterconnectionPoint.InterconnectionPointBuilder setValue(String value);
		InterconnectionPoint.InterconnectionPointBuilder setInterconnectionPointScheme(String interconnectionPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("interconnectionPointScheme"), String.class, getInterconnectionPointScheme(), this);
		}
		

		InterconnectionPoint.InterconnectionPointBuilder prune();
	}

	/*********************** Immutable Implementation of InterconnectionPoint  ***********************/
	class InterconnectionPointImpl implements InterconnectionPoint {
		private final String value;
		private final String interconnectionPointScheme;
		
		protected InterconnectionPointImpl(InterconnectionPoint.InterconnectionPointBuilder builder) {
			this.value = builder.getValue();
			this.interconnectionPointScheme = builder.getInterconnectionPointScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("interconnectionPointScheme")
		public String getInterconnectionPointScheme() {
			return interconnectionPointScheme;
		}
		
		@Override
		public InterconnectionPoint build() {
			return this;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder toBuilder() {
			InterconnectionPoint.InterconnectionPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterconnectionPoint.InterconnectionPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInterconnectionPointScheme()).ifPresent(builder::setInterconnectionPointScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterconnectionPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(interconnectionPointScheme, _that.getInterconnectionPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (interconnectionPointScheme != null ? interconnectionPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterconnectionPoint {" +
				"value=" + this.value + ", " +
				"interconnectionPointScheme=" + this.interconnectionPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of InterconnectionPoint  ***********************/
	class InterconnectionPointBuilderImpl implements InterconnectionPoint.InterconnectionPointBuilder {
	
		protected String value;
		protected String interconnectionPointScheme;
	
		public InterconnectionPointBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("interconnectionPointScheme")
		public String getInterconnectionPointScheme() {
			return interconnectionPointScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public InterconnectionPoint.InterconnectionPointBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("interconnectionPointScheme")
		public InterconnectionPoint.InterconnectionPointBuilder setInterconnectionPointScheme(String interconnectionPointScheme) {
			this.interconnectionPointScheme = interconnectionPointScheme==null?null:interconnectionPointScheme;
			return this;
		}
		
		@Override
		public InterconnectionPoint build() {
			return new InterconnectionPoint.InterconnectionPointImpl(this);
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInterconnectionPointScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterconnectionPoint.InterconnectionPointBuilder o = (InterconnectionPoint.InterconnectionPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInterconnectionPointScheme(), o.getInterconnectionPointScheme(), this::setInterconnectionPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterconnectionPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(interconnectionPointScheme, _that.getInterconnectionPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (interconnectionPointScheme != null ? interconnectionPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterconnectionPointBuilder {" +
				"value=" + this.value + ", " +
				"interconnectionPointScheme=" + this.interconnectionPointScheme +
			'}';
		}
	}
}
