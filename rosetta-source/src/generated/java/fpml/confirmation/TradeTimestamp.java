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
import fpml.confirmation.TimestampTypeScheme;
import fpml.confirmation.TradeTimestamp;
import fpml.confirmation.TradeTimestamp.TradeTimestampBuilder;
import fpml.confirmation.TradeTimestamp.TradeTimestampBuilderImpl;
import fpml.confirmation.TradeTimestamp.TradeTimestampImpl;
import fpml.confirmation.meta.TradeTimestampMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A generic trade timestamp
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTimestamp", builder=TradeTimestamp.TradeTimestampBuilderImpl.class, version="${project.version}")
public interface TradeTimestamp extends RosettaModelObject {

	TradeTimestampMeta metaData = new TradeTimestampMeta();

	/*********************** Getter Methods  ***********************/
	TimestampTypeScheme getType();
	ZonedDateTime getValue();

	/*********************** Build Methods  ***********************/
	TradeTimestamp build();
	
	TradeTimestamp.TradeTimestampBuilder toBuilder();
	
	static TradeTimestamp.TradeTimestampBuilder builder() {
		return new TradeTimestamp.TradeTimestampBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTimestamp> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeTimestamp> getType() {
		return TradeTimestamp.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, TimestampTypeScheme.class, getType());
		processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTimestampBuilder extends TradeTimestamp, RosettaModelObjectBuilder {
		TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreateType();
		TimestampTypeScheme.TimestampTypeSchemeBuilder getType();
		TradeTimestamp.TradeTimestampBuilder setType(TimestampTypeScheme type);
		TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, TimestampTypeScheme.TimestampTypeSchemeBuilder.class, getType());
			processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
		}
		

		TradeTimestamp.TradeTimestampBuilder prune();
	}

	/*********************** Immutable Implementation of TradeTimestamp  ***********************/
	class TradeTimestampImpl implements TradeTimestamp {
		private final TimestampTypeScheme type;
		private final ZonedDateTime value;
		
		protected TradeTimestampImpl(TradeTimestamp.TradeTimestampBuilder builder) {
			this.type = ofNullable(builder.getType()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("type")
		public TimestampTypeScheme getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		public TradeTimestamp build() {
			return this;
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			TradeTimestamp.TradeTimestampBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTimestamp.TradeTimestampBuilder builder) {
			ofNullable(getType()).ifPresent(builder::setType);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestamp {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTimestamp  ***********************/
	class TradeTimestampBuilderImpl implements TradeTimestamp.TradeTimestampBuilder {
	
		protected TimestampTypeScheme.TimestampTypeSchemeBuilder type;
		protected ZonedDateTime value;
	
		public TradeTimestampBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public TimestampTypeScheme.TimestampTypeSchemeBuilder getType() {
			return type;
		}
		
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreateType() {
			TimestampTypeScheme.TimestampTypeSchemeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = TimestampTypeScheme.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("type")
		public TradeTimestamp.TradeTimestampBuilder setType(TimestampTypeScheme type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("value")
		public TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public TradeTimestamp build() {
			return new TradeTimestamp.TradeTimestampImpl(this);
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType()!=null && getType().hasData()) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTimestamp.TradeTimestampBuilder o = (TradeTimestamp.TradeTimestampBuilder) other;
			
			merger.mergeRosetta(getType(), o.getType(), this::setType);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestampBuilder {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
