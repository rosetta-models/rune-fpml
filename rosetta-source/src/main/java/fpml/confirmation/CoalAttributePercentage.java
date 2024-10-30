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
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CoalAttributePercentage.CoalAttributePercentageBuilder;
import fpml.confirmation.CoalAttributePercentage.CoalAttributePercentageBuilderImpl;
import fpml.confirmation.CoalAttributePercentage.CoalAttributePercentageImpl;
import fpml.confirmation.CoalAttributePercentageSequence0;
import fpml.confirmation.CoalAttributePercentageSequence1;
import fpml.confirmation.meta.CoalAttributePercentageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the attributes of a coal quality measure as a percentage of the measured value.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalAttributePercentage", builder=CoalAttributePercentage.CoalAttributePercentageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalAttributePercentage extends RosettaModelObject {

	CoalAttributePercentageMeta metaData = new CoalAttributePercentageMeta();

	/*********************** Getter Methods  ***********************/
	CoalAttributePercentageSequence0 getCoalAttributePercentageSequence0();
	CoalAttributePercentageSequence1 getCoalAttributePercentageSequence1();

	/*********************** Build Methods  ***********************/
	CoalAttributePercentage build();
	
	CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder();
	
	static CoalAttributePercentage.CoalAttributePercentageBuilder builder() {
		return new CoalAttributePercentage.CoalAttributePercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributePercentage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributePercentage> getType() {
		return CoalAttributePercentage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("coalAttributePercentageSequence0"), processor, CoalAttributePercentageSequence0.class, getCoalAttributePercentageSequence0());
		processRosetta(path.newSubPath("coalAttributePercentageSequence1"), processor, CoalAttributePercentageSequence1.class, getCoalAttributePercentageSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributePercentageBuilder extends CoalAttributePercentage, RosettaModelObjectBuilder {
		CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder getOrCreateCoalAttributePercentageSequence0();
		CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder getCoalAttributePercentageSequence0();
		CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder getOrCreateCoalAttributePercentageSequence1();
		CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder getCoalAttributePercentageSequence1();
		CoalAttributePercentage.CoalAttributePercentageBuilder setCoalAttributePercentageSequence0(CoalAttributePercentageSequence0 coalAttributePercentageSequence0);
		CoalAttributePercentage.CoalAttributePercentageBuilder setCoalAttributePercentageSequence1(CoalAttributePercentageSequence1 coalAttributePercentageSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("coalAttributePercentageSequence0"), processor, CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder.class, getCoalAttributePercentageSequence0());
			processRosetta(path.newSubPath("coalAttributePercentageSequence1"), processor, CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder.class, getCoalAttributePercentageSequence1());
		}
		

		CoalAttributePercentage.CoalAttributePercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CoalAttributePercentage  ***********************/
	class CoalAttributePercentageImpl implements CoalAttributePercentage {
		private final CoalAttributePercentageSequence0 coalAttributePercentageSequence0;
		private final CoalAttributePercentageSequence1 coalAttributePercentageSequence1;
		
		protected CoalAttributePercentageImpl(CoalAttributePercentage.CoalAttributePercentageBuilder builder) {
			this.coalAttributePercentageSequence0 = ofNullable(builder.getCoalAttributePercentageSequence0()).map(f->f.build()).orElse(null);
			this.coalAttributePercentageSequence1 = ofNullable(builder.getCoalAttributePercentageSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coalAttributePercentageSequence0")
		public CoalAttributePercentageSequence0 getCoalAttributePercentageSequence0() {
			return coalAttributePercentageSequence0;
		}
		
		@Override
		@RosettaAttribute("coalAttributePercentageSequence1")
		public CoalAttributePercentageSequence1 getCoalAttributePercentageSequence1() {
			return coalAttributePercentageSequence1;
		}
		
		@Override
		public CoalAttributePercentage build() {
			return this;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder() {
			CoalAttributePercentage.CoalAttributePercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributePercentage.CoalAttributePercentageBuilder builder) {
			ofNullable(getCoalAttributePercentageSequence0()).ifPresent(builder::setCoalAttributePercentageSequence0);
			ofNullable(getCoalAttributePercentageSequence1()).ifPresent(builder::setCoalAttributePercentageSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentage _that = getType().cast(o);
		
			if (!Objects.equals(coalAttributePercentageSequence0, _that.getCoalAttributePercentageSequence0())) return false;
			if (!Objects.equals(coalAttributePercentageSequence1, _that.getCoalAttributePercentageSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coalAttributePercentageSequence0 != null ? coalAttributePercentageSequence0.hashCode() : 0);
			_result = 31 * _result + (coalAttributePercentageSequence1 != null ? coalAttributePercentageSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentage {" +
				"coalAttributePercentageSequence0=" + this.coalAttributePercentageSequence0 + ", " +
				"coalAttributePercentageSequence1=" + this.coalAttributePercentageSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributePercentage  ***********************/
	class CoalAttributePercentageBuilderImpl implements CoalAttributePercentage.CoalAttributePercentageBuilder {
	
		protected CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder coalAttributePercentageSequence0;
		protected CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder coalAttributePercentageSequence1;
	
		public CoalAttributePercentageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("coalAttributePercentageSequence0")
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder getCoalAttributePercentageSequence0() {
			return coalAttributePercentageSequence0;
		}
		
		@Override
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder getOrCreateCoalAttributePercentageSequence0() {
			CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder result;
			if (coalAttributePercentageSequence0!=null) {
				result = coalAttributePercentageSequence0;
			}
			else {
				result = coalAttributePercentageSequence0 = CoalAttributePercentageSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalAttributePercentageSequence1")
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder getCoalAttributePercentageSequence1() {
			return coalAttributePercentageSequence1;
		}
		
		@Override
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder getOrCreateCoalAttributePercentageSequence1() {
			CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder result;
			if (coalAttributePercentageSequence1!=null) {
				result = coalAttributePercentageSequence1;
			}
			else {
				result = coalAttributePercentageSequence1 = CoalAttributePercentageSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalAttributePercentageSequence0")
		public CoalAttributePercentage.CoalAttributePercentageBuilder setCoalAttributePercentageSequence0(CoalAttributePercentageSequence0 coalAttributePercentageSequence0) {
			this.coalAttributePercentageSequence0 = coalAttributePercentageSequence0==null?null:coalAttributePercentageSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coalAttributePercentageSequence1")
		public CoalAttributePercentage.CoalAttributePercentageBuilder setCoalAttributePercentageSequence1(CoalAttributePercentageSequence1 coalAttributePercentageSequence1) {
			this.coalAttributePercentageSequence1 = coalAttributePercentageSequence1==null?null:coalAttributePercentageSequence1.toBuilder();
			return this;
		}
		
		@Override
		public CoalAttributePercentage build() {
			return new CoalAttributePercentage.CoalAttributePercentageImpl(this);
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder prune() {
			if (coalAttributePercentageSequence0!=null && !coalAttributePercentageSequence0.prune().hasData()) coalAttributePercentageSequence0 = null;
			if (coalAttributePercentageSequence1!=null && !coalAttributePercentageSequence1.prune().hasData()) coalAttributePercentageSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoalAttributePercentageSequence0()!=null && getCoalAttributePercentageSequence0().hasData()) return true;
			if (getCoalAttributePercentageSequence1()!=null && getCoalAttributePercentageSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributePercentage.CoalAttributePercentageBuilder o = (CoalAttributePercentage.CoalAttributePercentageBuilder) other;
			
			merger.mergeRosetta(getCoalAttributePercentageSequence0(), o.getCoalAttributePercentageSequence0(), this::setCoalAttributePercentageSequence0);
			merger.mergeRosetta(getCoalAttributePercentageSequence1(), o.getCoalAttributePercentageSequence1(), this::setCoalAttributePercentageSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentage _that = getType().cast(o);
		
			if (!Objects.equals(coalAttributePercentageSequence0, _that.getCoalAttributePercentageSequence0())) return false;
			if (!Objects.equals(coalAttributePercentageSequence1, _that.getCoalAttributePercentageSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coalAttributePercentageSequence0 != null ? coalAttributePercentageSequence0.hashCode() : 0);
			_result = 31 * _result + (coalAttributePercentageSequence1 != null ? coalAttributePercentageSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentageBuilder {" +
				"coalAttributePercentageSequence0=" + this.coalAttributePercentageSequence0 + ", " +
				"coalAttributePercentageSequence1=" + this.coalAttributePercentageSequence1 +
			'}';
		}
	}
}
