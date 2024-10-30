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
import fpml.confirmation.Composite;
import fpml.confirmation.Composite.CompositeBuilder;
import fpml.confirmation.Composite.CompositeBuilderImpl;
import fpml.confirmation.Composite.CompositeImpl;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.CompositeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the conditions to be applied for converting into a reference currency when the actual currency rate is not determined upfront.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Composite", builder=Composite.CompositeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Composite extends RosettaModelObject {

	CompositeMeta metaData = new CompositeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();
	/**
	 * Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
	 */
	FxSpotRateSource getFxSpotRateSource();

	/*********************** Build Methods  ***********************/
	Composite build();
	
	Composite.CompositeBuilder toBuilder();
	
	static Composite.CompositeBuilder builder() {
		return new Composite.CompositeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Composite> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Composite> getType() {
		return Composite.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompositeBuilder extends Composite, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource();
		Composite.CompositeBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		Composite.CompositeBuilder setRelativeDate(RelativeDateOffset relativeDate);
		Composite.CompositeBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
		}
		

		Composite.CompositeBuilder prune();
	}

	/*********************** Immutable Implementation of Composite  ***********************/
	class CompositeImpl implements Composite {
		private final DeterminationMethod determinationMethod;
		private final RelativeDateOffset relativeDate;
		private final FxSpotRateSource fxSpotRateSource;
		
		protected CompositeImpl(Composite.CompositeBuilder builder) {
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
			this.fxSpotRateSource = ofNullable(builder.getFxSpotRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public Composite build() {
			return this;
		}
		
		@Override
		public Composite.CompositeBuilder toBuilder() {
			Composite.CompositeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Composite.CompositeBuilder builder) {
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
			ofNullable(getFxSpotRateSource()).ifPresent(builder::setFxSpotRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Composite _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Composite {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}

	/*********************** Builder Implementation of Composite  ***********************/
	class CompositeBuilderImpl implements Composite.CompositeBuilder {
	
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource;
	
		public CompositeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fxSpotRateSource!=null) {
				result = fxSpotRateSource;
			}
			else {
				result = fxSpotRateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public Composite.CompositeBuilder setDeterminationMethod(DeterminationMethod determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDate")
		public Composite.CompositeBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public Composite.CompositeBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource) {
			this.fxSpotRateSource = fxSpotRateSource==null?null:fxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		public Composite build() {
			return new Composite.CompositeImpl(this);
		}
		
		@Override
		public Composite.CompositeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Composite.CompositeBuilder prune() {
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			if (fxSpotRateSource!=null && !fxSpotRateSource.prune().hasData()) fxSpotRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			if (getFxSpotRateSource()!=null && getFxSpotRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Composite.CompositeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Composite.CompositeBuilder o = (Composite.CompositeBuilder) other;
			
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			merger.mergeRosetta(getFxSpotRateSource(), o.getFxSpotRateSource(), this::setFxSpotRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Composite _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompositeBuilder {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}
}
