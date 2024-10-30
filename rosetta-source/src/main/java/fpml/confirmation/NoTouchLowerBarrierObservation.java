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
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder;
import fpml.confirmation.NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl;
import fpml.confirmation.NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationImpl;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import fpml.confirmation.meta.NoTouchLowerBarrierObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NoTouchLowerBarrierObservation", builder=NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NoTouchLowerBarrierObservation extends RosettaModelObject {

	NoTouchLowerBarrierObservationMeta metaData = new NoTouchLowerBarrierObservationMeta();

	/*********************** Getter Methods  ***********************/
	NoTouchLowerBarrierObservationSequence0 getNoTouchLowerBarrierObservationSequence0();
	NoTouchLowerBarrierObservationSequence1 getNoTouchLowerBarrierObservationSequence1();

	/*********************** Build Methods  ***********************/
	NoTouchLowerBarrierObservation build();
	
	NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder();
	
	static NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder() {
		return new NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchLowerBarrierObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchLowerBarrierObservation> getType() {
		return NoTouchLowerBarrierObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("noTouchLowerBarrierObservationSequence0"), processor, NoTouchLowerBarrierObservationSequence0.class, getNoTouchLowerBarrierObservationSequence0());
		processRosetta(path.newSubPath("noTouchLowerBarrierObservationSequence1"), processor, NoTouchLowerBarrierObservationSequence1.class, getNoTouchLowerBarrierObservationSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchLowerBarrierObservationBuilder extends NoTouchLowerBarrierObservation, RosettaModelObjectBuilder {
		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder getOrCreateNoTouchLowerBarrierObservationSequence0();
		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder getNoTouchLowerBarrierObservationSequence0();
		NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder getOrCreateNoTouchLowerBarrierObservationSequence1();
		NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder getNoTouchLowerBarrierObservationSequence1();
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setNoTouchLowerBarrierObservationSequence0(NoTouchLowerBarrierObservationSequence0 noTouchLowerBarrierObservationSequence0);
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setNoTouchLowerBarrierObservationSequence1(NoTouchLowerBarrierObservationSequence1 noTouchLowerBarrierObservationSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("noTouchLowerBarrierObservationSequence0"), processor, NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder.class, getNoTouchLowerBarrierObservationSequence0());
			processRosetta(path.newSubPath("noTouchLowerBarrierObservationSequence1"), processor, NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder.class, getNoTouchLowerBarrierObservationSequence1());
		}
		

		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchLowerBarrierObservation  ***********************/
	class NoTouchLowerBarrierObservationImpl implements NoTouchLowerBarrierObservation {
		private final NoTouchLowerBarrierObservationSequence0 noTouchLowerBarrierObservationSequence0;
		private final NoTouchLowerBarrierObservationSequence1 noTouchLowerBarrierObservationSequence1;
		
		protected NoTouchLowerBarrierObservationImpl(NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder) {
			this.noTouchLowerBarrierObservationSequence0 = ofNullable(builder.getNoTouchLowerBarrierObservationSequence0()).map(f->f.build()).orElse(null);
			this.noTouchLowerBarrierObservationSequence1 = ofNullable(builder.getNoTouchLowerBarrierObservationSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence0")
		public NoTouchLowerBarrierObservationSequence0 getNoTouchLowerBarrierObservationSequence0() {
			return noTouchLowerBarrierObservationSequence0;
		}
		
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence1")
		public NoTouchLowerBarrierObservationSequence1 getNoTouchLowerBarrierObservationSequence1() {
			return noTouchLowerBarrierObservationSequence1;
		}
		
		@Override
		public NoTouchLowerBarrierObservation build() {
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder() {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder) {
			ofNullable(getNoTouchLowerBarrierObservationSequence0()).ifPresent(builder::setNoTouchLowerBarrierObservationSequence0);
			ofNullable(getNoTouchLowerBarrierObservationSequence1()).ifPresent(builder::setNoTouchLowerBarrierObservationSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(noTouchLowerBarrierObservationSequence0, _that.getNoTouchLowerBarrierObservationSequence0())) return false;
			if (!Objects.equals(noTouchLowerBarrierObservationSequence1, _that.getNoTouchLowerBarrierObservationSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (noTouchLowerBarrierObservationSequence0 != null ? noTouchLowerBarrierObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (noTouchLowerBarrierObservationSequence1 != null ? noTouchLowerBarrierObservationSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservation {" +
				"noTouchLowerBarrierObservationSequence0=" + this.noTouchLowerBarrierObservationSequence0 + ", " +
				"noTouchLowerBarrierObservationSequence1=" + this.noTouchLowerBarrierObservationSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchLowerBarrierObservation  ***********************/
	class NoTouchLowerBarrierObservationBuilderImpl implements NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder {
	
		protected NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder noTouchLowerBarrierObservationSequence0;
		protected NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder noTouchLowerBarrierObservationSequence1;
	
		public NoTouchLowerBarrierObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence0")
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder getNoTouchLowerBarrierObservationSequence0() {
			return noTouchLowerBarrierObservationSequence0;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder getOrCreateNoTouchLowerBarrierObservationSequence0() {
			NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder result;
			if (noTouchLowerBarrierObservationSequence0!=null) {
				result = noTouchLowerBarrierObservationSequence0;
			}
			else {
				result = noTouchLowerBarrierObservationSequence0 = NoTouchLowerBarrierObservationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence1")
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder getNoTouchLowerBarrierObservationSequence1() {
			return noTouchLowerBarrierObservationSequence1;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder getOrCreateNoTouchLowerBarrierObservationSequence1() {
			NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder result;
			if (noTouchLowerBarrierObservationSequence1!=null) {
				result = noTouchLowerBarrierObservationSequence1;
			}
			else {
				result = noTouchLowerBarrierObservationSequence1 = NoTouchLowerBarrierObservationSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence0")
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setNoTouchLowerBarrierObservationSequence0(NoTouchLowerBarrierObservationSequence0 noTouchLowerBarrierObservationSequence0) {
			this.noTouchLowerBarrierObservationSequence0 = noTouchLowerBarrierObservationSequence0==null?null:noTouchLowerBarrierObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noTouchLowerBarrierObservationSequence1")
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setNoTouchLowerBarrierObservationSequence1(NoTouchLowerBarrierObservationSequence1 noTouchLowerBarrierObservationSequence1) {
			this.noTouchLowerBarrierObservationSequence1 = noTouchLowerBarrierObservationSequence1==null?null:noTouchLowerBarrierObservationSequence1.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservation build() {
			return new NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationImpl(this);
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder prune() {
			if (noTouchLowerBarrierObservationSequence0!=null && !noTouchLowerBarrierObservationSequence0.prune().hasData()) noTouchLowerBarrierObservationSequence0 = null;
			if (noTouchLowerBarrierObservationSequence1!=null && !noTouchLowerBarrierObservationSequence1.prune().hasData()) noTouchLowerBarrierObservationSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNoTouchLowerBarrierObservationSequence0()!=null && getNoTouchLowerBarrierObservationSequence0().hasData()) return true;
			if (getNoTouchLowerBarrierObservationSequence1()!=null && getNoTouchLowerBarrierObservationSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder o = (NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder) other;
			
			merger.mergeRosetta(getNoTouchLowerBarrierObservationSequence0(), o.getNoTouchLowerBarrierObservationSequence0(), this::setNoTouchLowerBarrierObservationSequence0);
			merger.mergeRosetta(getNoTouchLowerBarrierObservationSequence1(), o.getNoTouchLowerBarrierObservationSequence1(), this::setNoTouchLowerBarrierObservationSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(noTouchLowerBarrierObservationSequence0, _that.getNoTouchLowerBarrierObservationSequence0())) return false;
			if (!Objects.equals(noTouchLowerBarrierObservationSequence1, _that.getNoTouchLowerBarrierObservationSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (noTouchLowerBarrierObservationSequence0 != null ? noTouchLowerBarrierObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (noTouchLowerBarrierObservationSequence1 != null ? noTouchLowerBarrierObservationSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationBuilder {" +
				"noTouchLowerBarrierObservationSequence0=" + this.noTouchLowerBarrierObservationSequence0 + ", " +
				"noTouchLowerBarrierObservationSequence1=" + this.noTouchLowerBarrierObservationSequence1 +
			'}';
		}
	}
}
