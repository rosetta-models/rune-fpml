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
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.FeeLegChoice.FeeLegChoiceBuilder;
import fpml.confirmation.FeeLegChoice.FeeLegChoiceBuilderImpl;
import fpml.confirmation.FeeLegChoice.FeeLegChoiceImpl;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.FeeLegChoiceSequence1;
import fpml.confirmation.meta.FeeLegChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FeeLegChoice", builder=FeeLegChoice.FeeLegChoiceBuilderImpl.class, version="${project.version}")
public interface FeeLegChoice extends RosettaModelObject {

	FeeLegChoiceMeta metaData = new FeeLegChoiceMeta();

	/*********************** Getter Methods  ***********************/
	FeeLegChoiceSequence0 getFeeLegChoiceSequence0();
	FeeLegChoiceSequence1 getFeeLegChoiceSequence1();

	/*********************** Build Methods  ***********************/
	FeeLegChoice build();
	
	FeeLegChoice.FeeLegChoiceBuilder toBuilder();
	
	static FeeLegChoice.FeeLegChoiceBuilder builder() {
		return new FeeLegChoice.FeeLegChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeLegChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeLegChoice> getType() {
		return FeeLegChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("feeLegChoiceSequence0"), processor, FeeLegChoiceSequence0.class, getFeeLegChoiceSequence0());
		processRosetta(path.newSubPath("feeLegChoiceSequence1"), processor, FeeLegChoiceSequence1.class, getFeeLegChoiceSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeLegChoiceBuilder extends FeeLegChoice, RosettaModelObjectBuilder {
		FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder getOrCreateFeeLegChoiceSequence0();
		FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder getFeeLegChoiceSequence0();
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder getOrCreateFeeLegChoiceSequence1();
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder getFeeLegChoiceSequence1();
		FeeLegChoice.FeeLegChoiceBuilder setFeeLegChoiceSequence0(FeeLegChoiceSequence0 feeLegChoiceSequence0);
		FeeLegChoice.FeeLegChoiceBuilder setFeeLegChoiceSequence1(FeeLegChoiceSequence1 feeLegChoiceSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("feeLegChoiceSequence0"), processor, FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder.class, getFeeLegChoiceSequence0());
			processRosetta(path.newSubPath("feeLegChoiceSequence1"), processor, FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder.class, getFeeLegChoiceSequence1());
		}
		

		FeeLegChoice.FeeLegChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of FeeLegChoice  ***********************/
	class FeeLegChoiceImpl implements FeeLegChoice {
		private final FeeLegChoiceSequence0 feeLegChoiceSequence0;
		private final FeeLegChoiceSequence1 feeLegChoiceSequence1;
		
		protected FeeLegChoiceImpl(FeeLegChoice.FeeLegChoiceBuilder builder) {
			this.feeLegChoiceSequence0 = ofNullable(builder.getFeeLegChoiceSequence0()).map(f->f.build()).orElse(null);
			this.feeLegChoiceSequence1 = ofNullable(builder.getFeeLegChoiceSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeLegChoiceSequence0")
		public FeeLegChoiceSequence0 getFeeLegChoiceSequence0() {
			return feeLegChoiceSequence0;
		}
		
		@Override
		@RosettaAttribute("feeLegChoiceSequence1")
		public FeeLegChoiceSequence1 getFeeLegChoiceSequence1() {
			return feeLegChoiceSequence1;
		}
		
		@Override
		public FeeLegChoice build() {
			return this;
		}
		
		@Override
		public FeeLegChoice.FeeLegChoiceBuilder toBuilder() {
			FeeLegChoice.FeeLegChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeLegChoice.FeeLegChoiceBuilder builder) {
			ofNullable(getFeeLegChoiceSequence0()).ifPresent(builder::setFeeLegChoiceSequence0);
			ofNullable(getFeeLegChoiceSequence1()).ifPresent(builder::setFeeLegChoiceSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoice _that = getType().cast(o);
		
			if (!Objects.equals(feeLegChoiceSequence0, _that.getFeeLegChoiceSequence0())) return false;
			if (!Objects.equals(feeLegChoiceSequence1, _that.getFeeLegChoiceSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeLegChoiceSequence0 != null ? feeLegChoiceSequence0.hashCode() : 0);
			_result = 31 * _result + (feeLegChoiceSequence1 != null ? feeLegChoiceSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoice {" +
				"feeLegChoiceSequence0=" + this.feeLegChoiceSequence0 + ", " +
				"feeLegChoiceSequence1=" + this.feeLegChoiceSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of FeeLegChoice  ***********************/
	class FeeLegChoiceBuilderImpl implements FeeLegChoice.FeeLegChoiceBuilder {
	
		protected FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder feeLegChoiceSequence0;
		protected FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder feeLegChoiceSequence1;
	
		public FeeLegChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeLegChoiceSequence0")
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder getFeeLegChoiceSequence0() {
			return feeLegChoiceSequence0;
		}
		
		@Override
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder getOrCreateFeeLegChoiceSequence0() {
			FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder result;
			if (feeLegChoiceSequence0!=null) {
				result = feeLegChoiceSequence0;
			}
			else {
				result = feeLegChoiceSequence0 = FeeLegChoiceSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeLegChoiceSequence1")
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder getFeeLegChoiceSequence1() {
			return feeLegChoiceSequence1;
		}
		
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder getOrCreateFeeLegChoiceSequence1() {
			FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder result;
			if (feeLegChoiceSequence1!=null) {
				result = feeLegChoiceSequence1;
			}
			else {
				result = feeLegChoiceSequence1 = FeeLegChoiceSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeLegChoiceSequence0")
		public FeeLegChoice.FeeLegChoiceBuilder setFeeLegChoiceSequence0(FeeLegChoiceSequence0 feeLegChoiceSequence0) {
			this.feeLegChoiceSequence0 = feeLegChoiceSequence0==null?null:feeLegChoiceSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeLegChoiceSequence1")
		public FeeLegChoice.FeeLegChoiceBuilder setFeeLegChoiceSequence1(FeeLegChoiceSequence1 feeLegChoiceSequence1) {
			this.feeLegChoiceSequence1 = feeLegChoiceSequence1==null?null:feeLegChoiceSequence1.toBuilder();
			return this;
		}
		
		@Override
		public FeeLegChoice build() {
			return new FeeLegChoice.FeeLegChoiceImpl(this);
		}
		
		@Override
		public FeeLegChoice.FeeLegChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoice.FeeLegChoiceBuilder prune() {
			if (feeLegChoiceSequence0!=null && !feeLegChoiceSequence0.prune().hasData()) feeLegChoiceSequence0 = null;
			if (feeLegChoiceSequence1!=null && !feeLegChoiceSequence1.prune().hasData()) feeLegChoiceSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeeLegChoiceSequence0()!=null && getFeeLegChoiceSequence0().hasData()) return true;
			if (getFeeLegChoiceSequence1()!=null && getFeeLegChoiceSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoice.FeeLegChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeeLegChoice.FeeLegChoiceBuilder o = (FeeLegChoice.FeeLegChoiceBuilder) other;
			
			merger.mergeRosetta(getFeeLegChoiceSequence0(), o.getFeeLegChoiceSequence0(), this::setFeeLegChoiceSequence0);
			merger.mergeRosetta(getFeeLegChoiceSequence1(), o.getFeeLegChoiceSequence1(), this::setFeeLegChoiceSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoice _that = getType().cast(o);
		
			if (!Objects.equals(feeLegChoiceSequence0, _that.getFeeLegChoiceSequence0())) return false;
			if (!Objects.equals(feeLegChoiceSequence1, _that.getFeeLegChoiceSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeLegChoiceSequence0 != null ? feeLegChoiceSequence0.hashCode() : 0);
			_result = 31 * _result + (feeLegChoiceSequence1 != null ? feeLegChoiceSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoiceBuilder {" +
				"feeLegChoiceSequence0=" + this.feeLegChoiceSequence0 + ", " +
				"feeLegChoiceSequence1=" + this.feeLegChoiceSequence1 +
			'}';
		}
	}
}
