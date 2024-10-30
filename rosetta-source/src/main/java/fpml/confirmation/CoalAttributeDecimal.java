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
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CoalAttributeDecimal.CoalAttributeDecimalBuilder;
import fpml.confirmation.CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl;
import fpml.confirmation.CoalAttributeDecimal.CoalAttributeDecimalImpl;
import fpml.confirmation.CoalAttributeDecimalSequence0;
import fpml.confirmation.CoalAttributeDecimalSequence1;
import fpml.confirmation.meta.CoalAttributeDecimalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the attributes of a coal quality measure as a decimal value.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalAttributeDecimal", builder=CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalAttributeDecimal extends RosettaModelObject {

	CoalAttributeDecimalMeta metaData = new CoalAttributeDecimalMeta();

	/*********************** Getter Methods  ***********************/
	CoalAttributeDecimalSequence0 getCoalAttributeDecimalSequence0();
	CoalAttributeDecimalSequence1 getCoalAttributeDecimalSequence1();

	/*********************** Build Methods  ***********************/
	CoalAttributeDecimal build();
	
	CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder();
	
	static CoalAttributeDecimal.CoalAttributeDecimalBuilder builder() {
		return new CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributeDecimal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributeDecimal> getType() {
		return CoalAttributeDecimal.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("coalAttributeDecimalSequence0"), processor, CoalAttributeDecimalSequence0.class, getCoalAttributeDecimalSequence0());
		processRosetta(path.newSubPath("coalAttributeDecimalSequence1"), processor, CoalAttributeDecimalSequence1.class, getCoalAttributeDecimalSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributeDecimalBuilder extends CoalAttributeDecimal, RosettaModelObjectBuilder {
		CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder getOrCreateCoalAttributeDecimalSequence0();
		CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder getCoalAttributeDecimalSequence0();
		CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder getOrCreateCoalAttributeDecimalSequence1();
		CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder getCoalAttributeDecimalSequence1();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder setCoalAttributeDecimalSequence0(CoalAttributeDecimalSequence0 coalAttributeDecimalSequence0);
		CoalAttributeDecimal.CoalAttributeDecimalBuilder setCoalAttributeDecimalSequence1(CoalAttributeDecimalSequence1 coalAttributeDecimalSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("coalAttributeDecimalSequence0"), processor, CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder.class, getCoalAttributeDecimalSequence0());
			processRosetta(path.newSubPath("coalAttributeDecimalSequence1"), processor, CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder.class, getCoalAttributeDecimalSequence1());
		}
		

		CoalAttributeDecimal.CoalAttributeDecimalBuilder prune();
	}

	/*********************** Immutable Implementation of CoalAttributeDecimal  ***********************/
	class CoalAttributeDecimalImpl implements CoalAttributeDecimal {
		private final CoalAttributeDecimalSequence0 coalAttributeDecimalSequence0;
		private final CoalAttributeDecimalSequence1 coalAttributeDecimalSequence1;
		
		protected CoalAttributeDecimalImpl(CoalAttributeDecimal.CoalAttributeDecimalBuilder builder) {
			this.coalAttributeDecimalSequence0 = ofNullable(builder.getCoalAttributeDecimalSequence0()).map(f->f.build()).orElse(null);
			this.coalAttributeDecimalSequence1 = ofNullable(builder.getCoalAttributeDecimalSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence0")
		public CoalAttributeDecimalSequence0 getCoalAttributeDecimalSequence0() {
			return coalAttributeDecimalSequence0;
		}
		
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence1")
		public CoalAttributeDecimalSequence1 getCoalAttributeDecimalSequence1() {
			return coalAttributeDecimalSequence1;
		}
		
		@Override
		public CoalAttributeDecimal build() {
			return this;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributeDecimal.CoalAttributeDecimalBuilder builder) {
			ofNullable(getCoalAttributeDecimalSequence0()).ifPresent(builder::setCoalAttributeDecimalSequence0);
			ofNullable(getCoalAttributeDecimalSequence1()).ifPresent(builder::setCoalAttributeDecimalSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimal _that = getType().cast(o);
		
			if (!Objects.equals(coalAttributeDecimalSequence0, _that.getCoalAttributeDecimalSequence0())) return false;
			if (!Objects.equals(coalAttributeDecimalSequence1, _that.getCoalAttributeDecimalSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coalAttributeDecimalSequence0 != null ? coalAttributeDecimalSequence0.hashCode() : 0);
			_result = 31 * _result + (coalAttributeDecimalSequence1 != null ? coalAttributeDecimalSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributeDecimal {" +
				"coalAttributeDecimalSequence0=" + this.coalAttributeDecimalSequence0 + ", " +
				"coalAttributeDecimalSequence1=" + this.coalAttributeDecimalSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributeDecimal  ***********************/
	class CoalAttributeDecimalBuilderImpl implements CoalAttributeDecimal.CoalAttributeDecimalBuilder {
	
		protected CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder coalAttributeDecimalSequence0;
		protected CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder coalAttributeDecimalSequence1;
	
		public CoalAttributeDecimalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence0")
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder getCoalAttributeDecimalSequence0() {
			return coalAttributeDecimalSequence0;
		}
		
		@Override
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder getOrCreateCoalAttributeDecimalSequence0() {
			CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder result;
			if (coalAttributeDecimalSequence0!=null) {
				result = coalAttributeDecimalSequence0;
			}
			else {
				result = coalAttributeDecimalSequence0 = CoalAttributeDecimalSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence1")
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder getCoalAttributeDecimalSequence1() {
			return coalAttributeDecimalSequence1;
		}
		
		@Override
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder getOrCreateCoalAttributeDecimalSequence1() {
			CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder result;
			if (coalAttributeDecimalSequence1!=null) {
				result = coalAttributeDecimalSequence1;
			}
			else {
				result = coalAttributeDecimalSequence1 = CoalAttributeDecimalSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence0")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder setCoalAttributeDecimalSequence0(CoalAttributeDecimalSequence0 coalAttributeDecimalSequence0) {
			this.coalAttributeDecimalSequence0 = coalAttributeDecimalSequence0==null?null:coalAttributeDecimalSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coalAttributeDecimalSequence1")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder setCoalAttributeDecimalSequence1(CoalAttributeDecimalSequence1 coalAttributeDecimalSequence1) {
			this.coalAttributeDecimalSequence1 = coalAttributeDecimalSequence1==null?null:coalAttributeDecimalSequence1.toBuilder();
			return this;
		}
		
		@Override
		public CoalAttributeDecimal build() {
			return new CoalAttributeDecimal.CoalAttributeDecimalImpl(this);
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder prune() {
			if (coalAttributeDecimalSequence0!=null && !coalAttributeDecimalSequence0.prune().hasData()) coalAttributeDecimalSequence0 = null;
			if (coalAttributeDecimalSequence1!=null && !coalAttributeDecimalSequence1.prune().hasData()) coalAttributeDecimalSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoalAttributeDecimalSequence0()!=null && getCoalAttributeDecimalSequence0().hasData()) return true;
			if (getCoalAttributeDecimalSequence1()!=null && getCoalAttributeDecimalSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder o = (CoalAttributeDecimal.CoalAttributeDecimalBuilder) other;
			
			merger.mergeRosetta(getCoalAttributeDecimalSequence0(), o.getCoalAttributeDecimalSequence0(), this::setCoalAttributeDecimalSequence0);
			merger.mergeRosetta(getCoalAttributeDecimalSequence1(), o.getCoalAttributeDecimalSequence1(), this::setCoalAttributeDecimalSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimal _that = getType().cast(o);
		
			if (!Objects.equals(coalAttributeDecimalSequence0, _that.getCoalAttributeDecimalSequence0())) return false;
			if (!Objects.equals(coalAttributeDecimalSequence1, _that.getCoalAttributeDecimalSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coalAttributeDecimalSequence0 != null ? coalAttributeDecimalSequence0.hashCode() : 0);
			_result = 31 * _result + (coalAttributeDecimalSequence1 != null ? coalAttributeDecimalSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributeDecimalBuilder {" +
				"coalAttributeDecimalSequence0=" + this.coalAttributeDecimalSequence0 + ", " +
				"coalAttributeDecimalSequence1=" + this.coalAttributeDecimalSequence1 +
			'}';
		}
	}
}
