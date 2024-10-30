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
import fpml.confirmation.InformationProvider;
import fpml.confirmation.InformationSource;
import fpml.confirmation.InformationSource.InformationSourceBuilder;
import fpml.confirmation.InformationSource.InformationSourceBuilderImpl;
import fpml.confirmation.InformationSource.InformationSourceImpl;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.meta.InformationSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the source for a piece of information (e.g. a rate refix or an fx fixing).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InformationSource", builder=InformationSource.InformationSourceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InformationSource extends RosettaModelObject {

	InformationSourceMeta metaData = new InformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An information source for obtaining a market rate. For example Bloomberg, Reuters, Telerate etc.
	 */
	InformationProvider getRateSource();
	/**
	 * A specific page for the rate source for obtaining a market rate.
	 */
	RateSourcePage getRateSourcePage();
	/**
	 * The heading for the rate source on a given rate source page.
	 */
	String getRateSourcePageHeading();

	/*********************** Build Methods  ***********************/
	InformationSource build();
	
	InformationSource.InformationSourceBuilder toBuilder();
	
	static InformationSource.InformationSourceBuilder builder() {
		return new InformationSource.InformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InformationSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InformationSource> getType() {
		return InformationSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InformationSourceBuilder extends InformationSource, RosettaModelObjectBuilder {
		InformationProvider.InformationProviderBuilder getOrCreateRateSource();
		InformationProvider.InformationProviderBuilder getRateSource();
		RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage();
		RateSourcePage.RateSourcePageBuilder getRateSourcePage();
		InformationSource.InformationSourceBuilder setRateSource(InformationProvider rateSource);
		InformationSource.InformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		InformationSource.InformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.InformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		}
		

		InformationSource.InformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of InformationSource  ***********************/
	class InformationSourceImpl implements InformationSource {
		private final InformationProvider rateSource;
		private final RateSourcePage rateSourcePage;
		private final String rateSourcePageHeading;
		
		protected InformationSourceImpl(InformationSource.InformationSourceBuilder builder) {
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
			this.rateSourcePage = ofNullable(builder.getRateSourcePage()).map(f->f.build()).orElse(null);
			this.rateSourcePageHeading = builder.getRateSourcePageHeading();
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public InformationProvider getRateSource() {
			return rateSource;
		}
		
		@Override
		@RosettaAttribute("rateSourcePage")
		public RateSourcePage getRateSourcePage() {
			return rateSourcePage;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		public String getRateSourcePageHeading() {
			return rateSourcePageHeading;
		}
		
		@Override
		public InformationSource build() {
			return this;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			InformationSource.InformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InformationSource.InformationSourceBuilder builder) {
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
			ofNullable(getRateSourcePage()).ifPresent(builder::setRateSourcePage);
			ofNullable(getRateSourcePageHeading()).ifPresent(builder::setRateSourcePageHeading);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			if (!Objects.equals(rateSourcePage, _that.getRateSourcePage())) return false;
			if (!Objects.equals(rateSourcePageHeading, _that.getRateSourcePageHeading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			_result = 31 * _result + (rateSourcePage != null ? rateSourcePage.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageHeading != null ? rateSourcePageHeading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationSource {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}

	/*********************** Builder Implementation of InformationSource  ***********************/
	class InformationSourceBuilderImpl implements InformationSource.InformationSourceBuilder {
	
		protected InformationProvider.InformationProviderBuilder rateSource;
		protected RateSourcePage.RateSourcePageBuilder rateSourcePage;
		protected String rateSourcePageHeading;
	
		public InformationSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rateSource")
		public InformationProvider.InformationProviderBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public InformationProvider.InformationProviderBuilder getOrCreateRateSource() {
			InformationProvider.InformationProviderBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = InformationProvider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSourcePage")
		public RateSourcePage.RateSourcePageBuilder getRateSourcePage() {
			return rateSourcePage;
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage() {
			RateSourcePage.RateSourcePageBuilder result;
			if (rateSourcePage!=null) {
				result = rateSourcePage;
			}
			else {
				result = rateSourcePage = RateSourcePage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		public String getRateSourcePageHeading() {
			return rateSourcePageHeading;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public InformationSource.InformationSourceBuilder setRateSource(InformationProvider rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePage")
		public InformationSource.InformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage) {
			this.rateSourcePage = rateSourcePage==null?null:rateSourcePage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		public InformationSource.InformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading) {
			this.rateSourcePageHeading = rateSourcePageHeading==null?null:rateSourcePageHeading;
			return this;
		}
		
		@Override
		public InformationSource build() {
			return new InformationSource.InformationSourceImpl(this);
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationSource.InformationSourceBuilder prune() {
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			if (rateSourcePage!=null && !rateSourcePage.prune().hasData()) rateSourcePage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateSource()!=null && getRateSource().hasData()) return true;
			if (getRateSourcePage()!=null && getRateSourcePage().hasData()) return true;
			if (getRateSourcePageHeading()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationSource.InformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InformationSource.InformationSourceBuilder o = (InformationSource.InformationSourceBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			merger.mergeRosetta(getRateSourcePage(), o.getRateSourcePage(), this::setRateSourcePage);
			
			merger.mergeBasic(getRateSourcePageHeading(), o.getRateSourcePageHeading(), this::setRateSourcePageHeading);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			if (!Objects.equals(rateSourcePage, _that.getRateSourcePage())) return false;
			if (!Objects.equals(rateSourcePageHeading, _that.getRateSourcePageHeading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			_result = 31 * _result + (rateSourcePage != null ? rateSourcePage.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageHeading != null ? rateSourcePageHeading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationSourceBuilder {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}
}
