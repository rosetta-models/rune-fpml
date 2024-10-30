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
import fpml.confirmation.IdentifiedRate;
import fpml.confirmation.IdentifiedRate.IdentifiedRateBuilder;
import fpml.confirmation.IdentifiedRate.IdentifiedRateBuilderImpl;
import fpml.confirmation.IdentifiedRate.IdentifiedRateImpl;
import fpml.confirmation.meta.IdentifiedRateMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A rate which can be referenced elsewhere.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IdentifiedRate", builder=IdentifiedRate.IdentifiedRateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IdentifiedRate extends RosettaModelObject {

	IdentifiedRateMeta metaData = new IdentifiedRateMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedRate build();
	
	IdentifiedRate.IdentifiedRateBuilder toBuilder();
	
	static IdentifiedRate.IdentifiedRateBuilder builder() {
		return new IdentifiedRate.IdentifiedRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedRate> getType() {
		return IdentifiedRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedRateBuilder extends IdentifiedRate, RosettaModelObjectBuilder {
		IdentifiedRate.IdentifiedRateBuilder setValue(BigDecimal value);
		IdentifiedRate.IdentifiedRateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedRate.IdentifiedRateBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedRate  ***********************/
	class IdentifiedRateImpl implements IdentifiedRate {
		private final BigDecimal value;
		private final String id;
		
		protected IdentifiedRateImpl(IdentifiedRate.IdentifiedRateBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IdentifiedRate build() {
			return this;
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder toBuilder() {
			IdentifiedRate.IdentifiedRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedRate.IdentifiedRateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedRate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedRate {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of IdentifiedRate  ***********************/
	class IdentifiedRateBuilderImpl implements IdentifiedRate.IdentifiedRateBuilder {
	
		protected BigDecimal value;
		protected String id;
	
		public IdentifiedRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public IdentifiedRate.IdentifiedRateBuilder setValue(BigDecimal value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public IdentifiedRate.IdentifiedRateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public IdentifiedRate build() {
			return new IdentifiedRate.IdentifiedRateImpl(this);
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedRate.IdentifiedRateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedRate.IdentifiedRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IdentifiedRate.IdentifiedRateBuilder o = (IdentifiedRate.IdentifiedRateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedRate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedRateBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
