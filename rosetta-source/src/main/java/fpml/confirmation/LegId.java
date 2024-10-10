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
import fpml.confirmation.LegId;
import fpml.confirmation.LegId.LegIdBuilder;
import fpml.confirmation.LegId.LegIdBuilderImpl;
import fpml.confirmation.LegId.LegIdImpl;
import fpml.confirmation.meta.LegIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Leg identity.
 * @version ${project.version}
 */
@RosettaDataType(value="LegId", builder=LegId.LegIdBuilderImpl.class, version="${project.version}")
public interface LegId extends RosettaModelObject {

	LegIdMeta metaData = new LegIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLegIdScheme();

	/*********************** Build Methods  ***********************/
	LegId build();
	
	LegId.LegIdBuilder toBuilder();
	
	static LegId.LegIdBuilder builder() {
		return new LegId.LegIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegId> getType() {
		return LegId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("legIdScheme"), String.class, getLegIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegIdBuilder extends LegId, RosettaModelObjectBuilder {
		LegId.LegIdBuilder setValue(String value);
		LegId.LegIdBuilder setLegIdScheme(String legIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("legIdScheme"), String.class, getLegIdScheme(), this);
		}
		

		LegId.LegIdBuilder prune();
	}

	/*********************** Immutable Implementation of LegId  ***********************/
	class LegIdImpl implements LegId {
		private final String value;
		private final String legIdScheme;
		
		protected LegIdImpl(LegId.LegIdBuilder builder) {
			this.value = builder.getValue();
			this.legIdScheme = builder.getLegIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("legIdScheme")
		public String getLegIdScheme() {
			return legIdScheme;
		}
		
		@Override
		public LegId build() {
			return this;
		}
		
		@Override
		public LegId.LegIdBuilder toBuilder() {
			LegId.LegIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegId.LegIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLegIdScheme()).ifPresent(builder::setLegIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legIdScheme, _that.getLegIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legIdScheme != null ? legIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegId {" +
				"value=" + this.value + ", " +
				"legIdScheme=" + this.legIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LegId  ***********************/
	class LegIdBuilderImpl implements LegId.LegIdBuilder {
	
		protected String value;
		protected String legIdScheme;
	
		public LegIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("legIdScheme")
		public String getLegIdScheme() {
			return legIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LegId.LegIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("legIdScheme")
		public LegId.LegIdBuilder setLegIdScheme(String legIdScheme) {
			this.legIdScheme = legIdScheme==null?null:legIdScheme;
			return this;
		}
		
		@Override
		public LegId build() {
			return new LegId.LegIdImpl(this);
		}
		
		@Override
		public LegId.LegIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegId.LegIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLegIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegId.LegIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegId.LegIdBuilder o = (LegId.LegIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLegIdScheme(), o.getLegIdScheme(), this::setLegIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legIdScheme, _that.getLegIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legIdScheme != null ? legIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegIdBuilder {" +
				"value=" + this.value + ", " +
				"legIdScheme=" + this.legIdScheme +
			'}';
		}
	}
}
