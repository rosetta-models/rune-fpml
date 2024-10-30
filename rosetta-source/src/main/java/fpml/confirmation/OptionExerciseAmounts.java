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
import fpml.confirmation.OptionExerciseAmounts;
import fpml.confirmation.OptionExerciseAmounts.OptionExerciseAmountsBuilder;
import fpml.confirmation.OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl;
import fpml.confirmation.OptionExerciseAmounts.OptionExerciseAmountsImpl;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import fpml.confirmation.meta.OptionExerciseAmountsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionExerciseAmounts", builder=OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionExerciseAmounts extends RosettaModelObject {

	OptionExerciseAmountsMeta metaData = new OptionExerciseAmountsMeta();

	/*********************** Getter Methods  ***********************/
	OptionExerciseAmountsSequence0 getOptionExerciseAmountsSequence0();
	OptionExerciseAmountsSequence1 getOptionExerciseAmountsSequence1();
	OptionExerciseAmountsSequence2 getOptionExerciseAmountsSequence2();
	OptionExerciseAmountsSequence3 getOptionExerciseAmountsSequence3();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmounts build();
	
	OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder();
	
	static OptionExerciseAmounts.OptionExerciseAmountsBuilder builder() {
		return new OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmounts> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmounts> getType() {
		return OptionExerciseAmounts.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionExerciseAmountsSequence0"), processor, OptionExerciseAmountsSequence0.class, getOptionExerciseAmountsSequence0());
		processRosetta(path.newSubPath("optionExerciseAmountsSequence1"), processor, OptionExerciseAmountsSequence1.class, getOptionExerciseAmountsSequence1());
		processRosetta(path.newSubPath("optionExerciseAmountsSequence2"), processor, OptionExerciseAmountsSequence2.class, getOptionExerciseAmountsSequence2());
		processRosetta(path.newSubPath("optionExerciseAmountsSequence3"), processor, OptionExerciseAmountsSequence3.class, getOptionExerciseAmountsSequence3());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsBuilder extends OptionExerciseAmounts, RosettaModelObjectBuilder {
		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder getOrCreateOptionExerciseAmountsSequence0();
		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder getOptionExerciseAmountsSequence0();
		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder getOrCreateOptionExerciseAmountsSequence1();
		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder getOptionExerciseAmountsSequence1();
		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder getOrCreateOptionExerciseAmountsSequence2();
		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder getOptionExerciseAmountsSequence2();
		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder getOrCreateOptionExerciseAmountsSequence3();
		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder getOptionExerciseAmountsSequence3();
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence0(OptionExerciseAmountsSequence0 optionExerciseAmountsSequence0);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence1(OptionExerciseAmountsSequence1 optionExerciseAmountsSequence1);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence2(OptionExerciseAmountsSequence2 optionExerciseAmountsSequence2);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence3(OptionExerciseAmountsSequence3 optionExerciseAmountsSequence3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionExerciseAmountsSequence0"), processor, OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder.class, getOptionExerciseAmountsSequence0());
			processRosetta(path.newSubPath("optionExerciseAmountsSequence1"), processor, OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder.class, getOptionExerciseAmountsSequence1());
			processRosetta(path.newSubPath("optionExerciseAmountsSequence2"), processor, OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder.class, getOptionExerciseAmountsSequence2());
			processRosetta(path.newSubPath("optionExerciseAmountsSequence3"), processor, OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder.class, getOptionExerciseAmountsSequence3());
		}
		

		OptionExerciseAmounts.OptionExerciseAmountsBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmounts  ***********************/
	class OptionExerciseAmountsImpl implements OptionExerciseAmounts {
		private final OptionExerciseAmountsSequence0 optionExerciseAmountsSequence0;
		private final OptionExerciseAmountsSequence1 optionExerciseAmountsSequence1;
		private final OptionExerciseAmountsSequence2 optionExerciseAmountsSequence2;
		private final OptionExerciseAmountsSequence3 optionExerciseAmountsSequence3;
		
		protected OptionExerciseAmountsImpl(OptionExerciseAmounts.OptionExerciseAmountsBuilder builder) {
			this.optionExerciseAmountsSequence0 = ofNullable(builder.getOptionExerciseAmountsSequence0()).map(f->f.build()).orElse(null);
			this.optionExerciseAmountsSequence1 = ofNullable(builder.getOptionExerciseAmountsSequence1()).map(f->f.build()).orElse(null);
			this.optionExerciseAmountsSequence2 = ofNullable(builder.getOptionExerciseAmountsSequence2()).map(f->f.build()).orElse(null);
			this.optionExerciseAmountsSequence3 = ofNullable(builder.getOptionExerciseAmountsSequence3()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence0")
		public OptionExerciseAmountsSequence0 getOptionExerciseAmountsSequence0() {
			return optionExerciseAmountsSequence0;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence1")
		public OptionExerciseAmountsSequence1 getOptionExerciseAmountsSequence1() {
			return optionExerciseAmountsSequence1;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence2")
		public OptionExerciseAmountsSequence2 getOptionExerciseAmountsSequence2() {
			return optionExerciseAmountsSequence2;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence3")
		public OptionExerciseAmountsSequence3 getOptionExerciseAmountsSequence3() {
			return optionExerciseAmountsSequence3;
		}
		
		@Override
		public OptionExerciseAmounts build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder() {
			OptionExerciseAmounts.OptionExerciseAmountsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmounts.OptionExerciseAmountsBuilder builder) {
			ofNullable(getOptionExerciseAmountsSequence0()).ifPresent(builder::setOptionExerciseAmountsSequence0);
			ofNullable(getOptionExerciseAmountsSequence1()).ifPresent(builder::setOptionExerciseAmountsSequence1);
			ofNullable(getOptionExerciseAmountsSequence2()).ifPresent(builder::setOptionExerciseAmountsSequence2);
			ofNullable(getOptionExerciseAmountsSequence3()).ifPresent(builder::setOptionExerciseAmountsSequence3);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmounts _that = getType().cast(o);
		
			if (!Objects.equals(optionExerciseAmountsSequence0, _that.getOptionExerciseAmountsSequence0())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence1, _that.getOptionExerciseAmountsSequence1())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence2, _that.getOptionExerciseAmountsSequence2())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence3, _that.getOptionExerciseAmountsSequence3())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExerciseAmountsSequence0 != null ? optionExerciseAmountsSequence0.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence1 != null ? optionExerciseAmountsSequence1.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence2 != null ? optionExerciseAmountsSequence2.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence3 != null ? optionExerciseAmountsSequence3.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmounts {" +
				"optionExerciseAmountsSequence0=" + this.optionExerciseAmountsSequence0 + ", " +
				"optionExerciseAmountsSequence1=" + this.optionExerciseAmountsSequence1 + ", " +
				"optionExerciseAmountsSequence2=" + this.optionExerciseAmountsSequence2 + ", " +
				"optionExerciseAmountsSequence3=" + this.optionExerciseAmountsSequence3 +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmounts  ***********************/
	class OptionExerciseAmountsBuilderImpl implements OptionExerciseAmounts.OptionExerciseAmountsBuilder {
	
		protected OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder optionExerciseAmountsSequence0;
		protected OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder optionExerciseAmountsSequence1;
		protected OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder optionExerciseAmountsSequence2;
		protected OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder optionExerciseAmountsSequence3;
	
		public OptionExerciseAmountsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence0")
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder getOptionExerciseAmountsSequence0() {
			return optionExerciseAmountsSequence0;
		}
		
		@Override
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder getOrCreateOptionExerciseAmountsSequence0() {
			OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder result;
			if (optionExerciseAmountsSequence0!=null) {
				result = optionExerciseAmountsSequence0;
			}
			else {
				result = optionExerciseAmountsSequence0 = OptionExerciseAmountsSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence1")
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder getOptionExerciseAmountsSequence1() {
			return optionExerciseAmountsSequence1;
		}
		
		@Override
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder getOrCreateOptionExerciseAmountsSequence1() {
			OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder result;
			if (optionExerciseAmountsSequence1!=null) {
				result = optionExerciseAmountsSequence1;
			}
			else {
				result = optionExerciseAmountsSequence1 = OptionExerciseAmountsSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence2")
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder getOptionExerciseAmountsSequence2() {
			return optionExerciseAmountsSequence2;
		}
		
		@Override
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder getOrCreateOptionExerciseAmountsSequence2() {
			OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder result;
			if (optionExerciseAmountsSequence2!=null) {
				result = optionExerciseAmountsSequence2;
			}
			else {
				result = optionExerciseAmountsSequence2 = OptionExerciseAmountsSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence3")
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder getOptionExerciseAmountsSequence3() {
			return optionExerciseAmountsSequence3;
		}
		
		@Override
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder getOrCreateOptionExerciseAmountsSequence3() {
			OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder result;
			if (optionExerciseAmountsSequence3!=null) {
				result = optionExerciseAmountsSequence3;
			}
			else {
				result = optionExerciseAmountsSequence3 = OptionExerciseAmountsSequence3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence0")
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence0(OptionExerciseAmountsSequence0 optionExerciseAmountsSequence0) {
			this.optionExerciseAmountsSequence0 = optionExerciseAmountsSequence0==null?null:optionExerciseAmountsSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence1")
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence1(OptionExerciseAmountsSequence1 optionExerciseAmountsSequence1) {
			this.optionExerciseAmountsSequence1 = optionExerciseAmountsSequence1==null?null:optionExerciseAmountsSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence2")
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence2(OptionExerciseAmountsSequence2 optionExerciseAmountsSequence2) {
			this.optionExerciseAmountsSequence2 = optionExerciseAmountsSequence2==null?null:optionExerciseAmountsSequence2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountsSequence3")
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOptionExerciseAmountsSequence3(OptionExerciseAmountsSequence3 optionExerciseAmountsSequence3) {
			this.optionExerciseAmountsSequence3 = optionExerciseAmountsSequence3==null?null:optionExerciseAmountsSequence3.toBuilder();
			return this;
		}
		
		@Override
		public OptionExerciseAmounts build() {
			return new OptionExerciseAmounts.OptionExerciseAmountsImpl(this);
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder prune() {
			if (optionExerciseAmountsSequence0!=null && !optionExerciseAmountsSequence0.prune().hasData()) optionExerciseAmountsSequence0 = null;
			if (optionExerciseAmountsSequence1!=null && !optionExerciseAmountsSequence1.prune().hasData()) optionExerciseAmountsSequence1 = null;
			if (optionExerciseAmountsSequence2!=null && !optionExerciseAmountsSequence2.prune().hasData()) optionExerciseAmountsSequence2 = null;
			if (optionExerciseAmountsSequence3!=null && !optionExerciseAmountsSequence3.prune().hasData()) optionExerciseAmountsSequence3 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionExerciseAmountsSequence0()!=null && getOptionExerciseAmountsSequence0().hasData()) return true;
			if (getOptionExerciseAmountsSequence1()!=null && getOptionExerciseAmountsSequence1().hasData()) return true;
			if (getOptionExerciseAmountsSequence2()!=null && getOptionExerciseAmountsSequence2().hasData()) return true;
			if (getOptionExerciseAmountsSequence3()!=null && getOptionExerciseAmountsSequence3().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmounts.OptionExerciseAmountsBuilder o = (OptionExerciseAmounts.OptionExerciseAmountsBuilder) other;
			
			merger.mergeRosetta(getOptionExerciseAmountsSequence0(), o.getOptionExerciseAmountsSequence0(), this::setOptionExerciseAmountsSequence0);
			merger.mergeRosetta(getOptionExerciseAmountsSequence1(), o.getOptionExerciseAmountsSequence1(), this::setOptionExerciseAmountsSequence1);
			merger.mergeRosetta(getOptionExerciseAmountsSequence2(), o.getOptionExerciseAmountsSequence2(), this::setOptionExerciseAmountsSequence2);
			merger.mergeRosetta(getOptionExerciseAmountsSequence3(), o.getOptionExerciseAmountsSequence3(), this::setOptionExerciseAmountsSequence3);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmounts _that = getType().cast(o);
		
			if (!Objects.equals(optionExerciseAmountsSequence0, _that.getOptionExerciseAmountsSequence0())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence1, _that.getOptionExerciseAmountsSequence1())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence2, _that.getOptionExerciseAmountsSequence2())) return false;
			if (!Objects.equals(optionExerciseAmountsSequence3, _that.getOptionExerciseAmountsSequence3())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExerciseAmountsSequence0 != null ? optionExerciseAmountsSequence0.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence1 != null ? optionExerciseAmountsSequence1.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence2 != null ? optionExerciseAmountsSequence2.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountsSequence3 != null ? optionExerciseAmountsSequence3.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsBuilder {" +
				"optionExerciseAmountsSequence0=" + this.optionExerciseAmountsSequence0 + ", " +
				"optionExerciseAmountsSequence1=" + this.optionExerciseAmountsSequence1 + ", " +
				"optionExerciseAmountsSequence2=" + this.optionExerciseAmountsSequence2 + ", " +
				"optionExerciseAmountsSequence3=" + this.optionExerciseAmountsSequence3 +
			'}';
		}
	}
}
