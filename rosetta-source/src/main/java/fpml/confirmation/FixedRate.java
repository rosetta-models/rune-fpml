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
import fpml.confirmation.FixedRate;
import fpml.confirmation.FixedRate.FixedRateBuilder;
import fpml.confirmation.FixedRate.FixedRateBuilderImpl;
import fpml.confirmation.FixedRate.FixedRateImpl;
import fpml.confirmation.meta.FixedRateMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRate", builder=FixedRate.FixedRateBuilderImpl.class, version="${project.version}")
public interface FixedRate extends RosettaModelObject {

	FixedRateMeta metaData = new FixedRateMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	FixedRate build();
	
	FixedRate.FixedRateBuilder toBuilder();
	
	static FixedRate.FixedRateBuilder builder() {
		return new FixedRate.FixedRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRate> getType() {
		return FixedRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateBuilder extends FixedRate, RosettaModelObjectBuilder {
		FixedRate.FixedRateBuilder setValue(BigDecimal value);
		FixedRate.FixedRateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FixedRate.FixedRateBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRate  ***********************/
	class FixedRateImpl implements FixedRate {
		private final BigDecimal value;
		private final String id;
		
		protected FixedRateImpl(FixedRate.FixedRateBuilder builder) {
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
		public FixedRate build() {
			return this;
		}
		
		@Override
		public FixedRate.FixedRateBuilder toBuilder() {
			FixedRate.FixedRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRate.FixedRateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRate _that = getType().cast(o);
		
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
			return "FixedRate {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedRate  ***********************/
	class FixedRateBuilderImpl implements FixedRate.FixedRateBuilder {
	
		protected BigDecimal value;
		protected String id;
	
		public FixedRateBuilderImpl() {
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
		public FixedRate.FixedRateBuilder setValue(BigDecimal value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FixedRate.FixedRateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FixedRate build() {
			return new FixedRate.FixedRateImpl(this);
		}
		
		@Override
		public FixedRate.FixedRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRate.FixedRateBuilder prune() {
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
		public FixedRate.FixedRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedRate.FixedRateBuilder o = (FixedRate.FixedRateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRate _that = getType().cast(o);
		
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
			return "FixedRateBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
