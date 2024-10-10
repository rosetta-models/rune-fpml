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
import fpml.confirmation.NoTouchUpperBarrierObservation;
import fpml.confirmation.NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder;
import fpml.confirmation.NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl;
import fpml.confirmation.NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationImpl;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import fpml.confirmation.meta.NoTouchUpperBarrierObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchUpperBarrierObservation", builder=NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl.class, version="${project.version}")
public interface NoTouchUpperBarrierObservation extends RosettaModelObject {

	NoTouchUpperBarrierObservationMeta metaData = new NoTouchUpperBarrierObservationMeta();

	/*********************** Getter Methods  ***********************/
	NoTouchUpperBarrierObservationSequence0 getNoTouchUpperBarrierObservationSequence0();
	NoTouchUpperBarrierObservationSequence1 getNoTouchUpperBarrierObservationSequence1();

	/*********************** Build Methods  ***********************/
	NoTouchUpperBarrierObservation build();
	
	NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder();
	
	static NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder() {
		return new NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchUpperBarrierObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchUpperBarrierObservation> getType() {
		return NoTouchUpperBarrierObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("noTouchUpperBarrierObservationSequence0"), processor, NoTouchUpperBarrierObservationSequence0.class, getNoTouchUpperBarrierObservationSequence0());
		processRosetta(path.newSubPath("noTouchUpperBarrierObservationSequence1"), processor, NoTouchUpperBarrierObservationSequence1.class, getNoTouchUpperBarrierObservationSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchUpperBarrierObservationBuilder extends NoTouchUpperBarrierObservation, RosettaModelObjectBuilder {
		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder getOrCreateNoTouchUpperBarrierObservationSequence0();
		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder getNoTouchUpperBarrierObservationSequence0();
		NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder getOrCreateNoTouchUpperBarrierObservationSequence1();
		NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder getNoTouchUpperBarrierObservationSequence1();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setNoTouchUpperBarrierObservationSequence0(NoTouchUpperBarrierObservationSequence0 noTouchUpperBarrierObservationSequence0);
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setNoTouchUpperBarrierObservationSequence1(NoTouchUpperBarrierObservationSequence1 noTouchUpperBarrierObservationSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("noTouchUpperBarrierObservationSequence0"), processor, NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder.class, getNoTouchUpperBarrierObservationSequence0());
			processRosetta(path.newSubPath("noTouchUpperBarrierObservationSequence1"), processor, NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder.class, getNoTouchUpperBarrierObservationSequence1());
		}
		

		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchUpperBarrierObservation  ***********************/
	class NoTouchUpperBarrierObservationImpl implements NoTouchUpperBarrierObservation {
		private final NoTouchUpperBarrierObservationSequence0 noTouchUpperBarrierObservationSequence0;
		private final NoTouchUpperBarrierObservationSequence1 noTouchUpperBarrierObservationSequence1;
		
		protected NoTouchUpperBarrierObservationImpl(NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder) {
			this.noTouchUpperBarrierObservationSequence0 = ofNullable(builder.getNoTouchUpperBarrierObservationSequence0()).map(f->f.build()).orElse(null);
			this.noTouchUpperBarrierObservationSequence1 = ofNullable(builder.getNoTouchUpperBarrierObservationSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence0")
		public NoTouchUpperBarrierObservationSequence0 getNoTouchUpperBarrierObservationSequence0() {
			return noTouchUpperBarrierObservationSequence0;
		}
		
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence1")
		public NoTouchUpperBarrierObservationSequence1 getNoTouchUpperBarrierObservationSequence1() {
			return noTouchUpperBarrierObservationSequence1;
		}
		
		@Override
		public NoTouchUpperBarrierObservation build() {
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder() {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder) {
			ofNullable(getNoTouchUpperBarrierObservationSequence0()).ifPresent(builder::setNoTouchUpperBarrierObservationSequence0);
			ofNullable(getNoTouchUpperBarrierObservationSequence1()).ifPresent(builder::setNoTouchUpperBarrierObservationSequence1);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(noTouchUpperBarrierObservationSequence0, _that.getNoTouchUpperBarrierObservationSequence0())) return false;
			if (!Objects.equals(noTouchUpperBarrierObservationSequence1, _that.getNoTouchUpperBarrierObservationSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (noTouchUpperBarrierObservationSequence0 != null ? noTouchUpperBarrierObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (noTouchUpperBarrierObservationSequence1 != null ? noTouchUpperBarrierObservationSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservation {" +
				"noTouchUpperBarrierObservationSequence0=" + this.noTouchUpperBarrierObservationSequence0 + ", " +
				"noTouchUpperBarrierObservationSequence1=" + this.noTouchUpperBarrierObservationSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchUpperBarrierObservation  ***********************/
	class NoTouchUpperBarrierObservationBuilderImpl implements NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder {
	
		protected NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder noTouchUpperBarrierObservationSequence0;
		protected NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder noTouchUpperBarrierObservationSequence1;
	
		public NoTouchUpperBarrierObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence0")
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder getNoTouchUpperBarrierObservationSequence0() {
			return noTouchUpperBarrierObservationSequence0;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder getOrCreateNoTouchUpperBarrierObservationSequence0() {
			NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder result;
			if (noTouchUpperBarrierObservationSequence0!=null) {
				result = noTouchUpperBarrierObservationSequence0;
			}
			else {
				result = noTouchUpperBarrierObservationSequence0 = NoTouchUpperBarrierObservationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence1")
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder getNoTouchUpperBarrierObservationSequence1() {
			return noTouchUpperBarrierObservationSequence1;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder getOrCreateNoTouchUpperBarrierObservationSequence1() {
			NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder result;
			if (noTouchUpperBarrierObservationSequence1!=null) {
				result = noTouchUpperBarrierObservationSequence1;
			}
			else {
				result = noTouchUpperBarrierObservationSequence1 = NoTouchUpperBarrierObservationSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence0")
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setNoTouchUpperBarrierObservationSequence0(NoTouchUpperBarrierObservationSequence0 noTouchUpperBarrierObservationSequence0) {
			this.noTouchUpperBarrierObservationSequence0 = noTouchUpperBarrierObservationSequence0==null?null:noTouchUpperBarrierObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noTouchUpperBarrierObservationSequence1")
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setNoTouchUpperBarrierObservationSequence1(NoTouchUpperBarrierObservationSequence1 noTouchUpperBarrierObservationSequence1) {
			this.noTouchUpperBarrierObservationSequence1 = noTouchUpperBarrierObservationSequence1==null?null:noTouchUpperBarrierObservationSequence1.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservation build() {
			return new NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationImpl(this);
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder prune() {
			if (noTouchUpperBarrierObservationSequence0!=null && !noTouchUpperBarrierObservationSequence0.prune().hasData()) noTouchUpperBarrierObservationSequence0 = null;
			if (noTouchUpperBarrierObservationSequence1!=null && !noTouchUpperBarrierObservationSequence1.prune().hasData()) noTouchUpperBarrierObservationSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNoTouchUpperBarrierObservationSequence0()!=null && getNoTouchUpperBarrierObservationSequence0().hasData()) return true;
			if (getNoTouchUpperBarrierObservationSequence1()!=null && getNoTouchUpperBarrierObservationSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder o = (NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder) other;
			
			merger.mergeRosetta(getNoTouchUpperBarrierObservationSequence0(), o.getNoTouchUpperBarrierObservationSequence0(), this::setNoTouchUpperBarrierObservationSequence0);
			merger.mergeRosetta(getNoTouchUpperBarrierObservationSequence1(), o.getNoTouchUpperBarrierObservationSequence1(), this::setNoTouchUpperBarrierObservationSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(noTouchUpperBarrierObservationSequence0, _that.getNoTouchUpperBarrierObservationSequence0())) return false;
			if (!Objects.equals(noTouchUpperBarrierObservationSequence1, _that.getNoTouchUpperBarrierObservationSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (noTouchUpperBarrierObservationSequence0 != null ? noTouchUpperBarrierObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (noTouchUpperBarrierObservationSequence1 != null ? noTouchUpperBarrierObservationSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationBuilder {" +
				"noTouchUpperBarrierObservationSequence0=" + this.noTouchUpperBarrierObservationSequence0 + ", " +
				"noTouchUpperBarrierObservationSequence1=" + this.noTouchUpperBarrierObservationSequence1 +
			'}';
		}
	}
}
