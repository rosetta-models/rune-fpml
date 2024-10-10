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
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.DayCountFraction.DayCountFractionBuilder;
import fpml.confirmation.DayCountFraction.DayCountFractionBuilderImpl;
import fpml.confirmation.DayCountFraction.DayCountFractionImpl;
import fpml.confirmation.meta.DayCountFractionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The specification for how the number of days between two dates is calculated for purposes of calculation of a fixed or floating payment amount and the basis for how many days are assumed to be in a year. Day Count Fraction is an ISDA term. The equivalent AFB (Association Francaise de Banques) term is Calculation Basis.
 * @version ${project.version}
 */
@RosettaDataType(value="DayCountFraction", builder=DayCountFraction.DayCountFractionBuilderImpl.class, version="${project.version}")
public interface DayCountFraction extends RosettaModelObject {

	DayCountFractionMeta metaData = new DayCountFractionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDayCountFractionScheme();

	/*********************** Build Methods  ***********************/
	DayCountFraction build();
	
	DayCountFraction.DayCountFractionBuilder toBuilder();
	
	static DayCountFraction.DayCountFractionBuilder builder() {
		return new DayCountFraction.DayCountFractionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DayCountFraction> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DayCountFraction> getType() {
		return DayCountFraction.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("dayCountFractionScheme"), String.class, getDayCountFractionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DayCountFractionBuilder extends DayCountFraction, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder setValue(String value);
		DayCountFraction.DayCountFractionBuilder setDayCountFractionScheme(String dayCountFractionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("dayCountFractionScheme"), String.class, getDayCountFractionScheme(), this);
		}
		

		DayCountFraction.DayCountFractionBuilder prune();
	}

	/*********************** Immutable Implementation of DayCountFraction  ***********************/
	class DayCountFractionImpl implements DayCountFraction {
		private final String value;
		private final String dayCountFractionScheme;
		
		protected DayCountFractionImpl(DayCountFraction.DayCountFractionBuilder builder) {
			this.value = builder.getValue();
			this.dayCountFractionScheme = builder.getDayCountFractionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("dayCountFractionScheme")
		public String getDayCountFractionScheme() {
			return dayCountFractionScheme;
		}
		
		@Override
		public DayCountFraction build() {
			return this;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder toBuilder() {
			DayCountFraction.DayCountFractionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DayCountFraction.DayCountFractionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDayCountFractionScheme()).ifPresent(builder::setDayCountFractionScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DayCountFraction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dayCountFractionScheme, _that.getDayCountFractionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dayCountFractionScheme != null ? dayCountFractionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DayCountFraction {" +
				"value=" + this.value + ", " +
				"dayCountFractionScheme=" + this.dayCountFractionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DayCountFraction  ***********************/
	class DayCountFractionBuilderImpl implements DayCountFraction.DayCountFractionBuilder {
	
		protected String value;
		protected String dayCountFractionScheme;
	
		public DayCountFractionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("dayCountFractionScheme")
		public String getDayCountFractionScheme() {
			return dayCountFractionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public DayCountFraction.DayCountFractionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFractionScheme")
		public DayCountFraction.DayCountFractionBuilder setDayCountFractionScheme(String dayCountFractionScheme) {
			this.dayCountFractionScheme = dayCountFractionScheme==null?null:dayCountFractionScheme;
			return this;
		}
		
		@Override
		public DayCountFraction build() {
			return new DayCountFraction.DayCountFractionImpl(this);
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DayCountFraction.DayCountFractionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDayCountFractionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DayCountFraction.DayCountFractionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DayCountFraction.DayCountFractionBuilder o = (DayCountFraction.DayCountFractionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDayCountFractionScheme(), o.getDayCountFractionScheme(), this::setDayCountFractionScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DayCountFraction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dayCountFractionScheme, _that.getDayCountFractionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dayCountFractionScheme != null ? dayCountFractionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DayCountFractionBuilder {" +
				"value=" + this.value + ", " +
				"dayCountFractionScheme=" + this.dayCountFractionScheme +
			'}';
		}
	}
}
