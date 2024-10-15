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
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.OriginatingEvent.OriginatingEventBuilder;
import fpml.confirmation.OriginatingEvent.OriginatingEventBuilderImpl;
import fpml.confirmation.OriginatingEvent.OriginatingEventImpl;
import fpml.confirmation.meta.OriginatingEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OriginatingEvent", builder=OriginatingEvent.OriginatingEventBuilderImpl.class, version="${project.version}")
public interface OriginatingEvent extends RosettaModelObject {

	OriginatingEventMeta metaData = new OriginatingEventMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getOriginatingEventScheme();

	/*********************** Build Methods  ***********************/
	OriginatingEvent build();
	
	OriginatingEvent.OriginatingEventBuilder toBuilder();
	
	static OriginatingEvent.OriginatingEventBuilder builder() {
		return new OriginatingEvent.OriginatingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OriginatingEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OriginatingEvent> getType() {
		return OriginatingEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("originatingEventScheme"), String.class, getOriginatingEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OriginatingEventBuilder extends OriginatingEvent, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder setValue(String value);
		OriginatingEvent.OriginatingEventBuilder setOriginatingEventScheme(String originatingEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("originatingEventScheme"), String.class, getOriginatingEventScheme(), this);
		}
		

		OriginatingEvent.OriginatingEventBuilder prune();
	}

	/*********************** Immutable Implementation of OriginatingEvent  ***********************/
	class OriginatingEventImpl implements OriginatingEvent {
		private final String value;
		private final String originatingEventScheme;
		
		protected OriginatingEventImpl(OriginatingEvent.OriginatingEventBuilder builder) {
			this.value = builder.getValue();
			this.originatingEventScheme = builder.getOriginatingEventScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("originatingEventScheme")
		public String getOriginatingEventScheme() {
			return originatingEventScheme;
		}
		
		@Override
		public OriginatingEvent build() {
			return this;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder toBuilder() {
			OriginatingEvent.OriginatingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OriginatingEvent.OriginatingEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOriginatingEventScheme()).ifPresent(builder::setOriginatingEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OriginatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(originatingEventScheme, _that.getOriginatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (originatingEventScheme != null ? originatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OriginatingEvent {" +
				"value=" + this.value + ", " +
				"originatingEventScheme=" + this.originatingEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OriginatingEvent  ***********************/
	class OriginatingEventBuilderImpl implements OriginatingEvent.OriginatingEventBuilder {
	
		protected String value;
		protected String originatingEventScheme;
	
		public OriginatingEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("originatingEventScheme")
		public String getOriginatingEventScheme() {
			return originatingEventScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OriginatingEvent.OriginatingEventBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("originatingEventScheme")
		public OriginatingEvent.OriginatingEventBuilder setOriginatingEventScheme(String originatingEventScheme) {
			this.originatingEventScheme = originatingEventScheme==null?null:originatingEventScheme;
			return this;
		}
		
		@Override
		public OriginatingEvent build() {
			return new OriginatingEvent.OriginatingEventImpl(this);
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OriginatingEvent.OriginatingEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOriginatingEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OriginatingEvent.OriginatingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OriginatingEvent.OriginatingEventBuilder o = (OriginatingEvent.OriginatingEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOriginatingEventScheme(), o.getOriginatingEventScheme(), this::setOriginatingEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OriginatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(originatingEventScheme, _that.getOriginatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (originatingEventScheme != null ? originatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OriginatingEventBuilder {" +
				"value=" + this.value + ", " +
				"originatingEventScheme=" + this.originatingEventScheme +
			'}';
		}
	}
}
