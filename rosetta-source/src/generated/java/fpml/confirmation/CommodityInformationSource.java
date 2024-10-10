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
import fpml.confirmation.CommodityInformationProvider;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.CommodityInformationSource.CommodityInformationSourceBuilder;
import fpml.confirmation.CommodityInformationSource.CommodityInformationSourceBuilderImpl;
import fpml.confirmation.CommodityInformationSource.CommodityInformationSourceImpl;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.meta.CommodityInformationSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the source of a commodity rate, price or index or of a market rate or of a conversion factor (e.g. a fx conversion factor).
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityInformationSource", builder=CommodityInformationSource.CommodityInformationSourceBuilderImpl.class, version="${project.version}")
public interface CommodityInformationSource extends RosettaModelObject {

	CommodityInformationSourceMeta metaData = new CommodityInformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
	 */
	CommodityInformationProvider getRateSource();
	/**
	 * A specific page or screen (in the case of electronically published information) on which the rate source is to be found.
	 */
	RateSourcePage getRateSourcePage();
	/**
	 * The heading for the rate source on a given rate source page or screen.
	 */
	String getRateSourcePageHeading();

	/*********************** Build Methods  ***********************/
	CommodityInformationSource build();
	
	CommodityInformationSource.CommodityInformationSourceBuilder toBuilder();
	
	static CommodityInformationSource.CommodityInformationSourceBuilder builder() {
		return new CommodityInformationSource.CommodityInformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityInformationSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityInformationSource> getType() {
		return CommodityInformationSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, CommodityInformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityInformationSourceBuilder extends CommodityInformationSource, RosettaModelObjectBuilder {
		CommodityInformationProvider.CommodityInformationProviderBuilder getOrCreateRateSource();
		CommodityInformationProvider.CommodityInformationProviderBuilder getRateSource();
		RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage();
		RateSourcePage.RateSourcePageBuilder getRateSourcePage();
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSource(CommodityInformationProvider rateSource);
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, CommodityInformationProvider.CommodityInformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		}
		

		CommodityInformationSource.CommodityInformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityInformationSource  ***********************/
	class CommodityInformationSourceImpl implements CommodityInformationSource {
		private final CommodityInformationProvider rateSource;
		private final RateSourcePage rateSourcePage;
		private final String rateSourcePageHeading;
		
		protected CommodityInformationSourceImpl(CommodityInformationSource.CommodityInformationSourceBuilder builder) {
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
			this.rateSourcePage = ofNullable(builder.getRateSourcePage()).map(f->f.build()).orElse(null);
			this.rateSourcePageHeading = builder.getRateSourcePageHeading();
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public CommodityInformationProvider getRateSource() {
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
		public CommodityInformationSource build() {
			return this;
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder toBuilder() {
			CommodityInformationSource.CommodityInformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityInformationSource.CommodityInformationSourceBuilder builder) {
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
			ofNullable(getRateSourcePage()).ifPresent(builder::setRateSourcePage);
			ofNullable(getRateSourcePageHeading()).ifPresent(builder::setRateSourcePageHeading);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationSource _that = getType().cast(o);
		
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
			return "CommodityInformationSource {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityInformationSource  ***********************/
	class CommodityInformationSourceBuilderImpl implements CommodityInformationSource.CommodityInformationSourceBuilder {
	
		protected CommodityInformationProvider.CommodityInformationProviderBuilder rateSource;
		protected RateSourcePage.RateSourcePageBuilder rateSourcePage;
		protected String rateSourcePageHeading;
	
		public CommodityInformationSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rateSource")
		public CommodityInformationProvider.CommodityInformationProviderBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder getOrCreateRateSource() {
			CommodityInformationProvider.CommodityInformationProviderBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = CommodityInformationProvider.builder();
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
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSource(CommodityInformationProvider rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePage")
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage) {
			this.rateSourcePage = rateSourcePage==null?null:rateSourcePage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading) {
			this.rateSourcePageHeading = rateSourcePageHeading==null?null:rateSourcePageHeading;
			return this;
		}
		
		@Override
		public CommodityInformationSource build() {
			return new CommodityInformationSource.CommodityInformationSourceImpl(this);
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder prune() {
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
		public CommodityInformationSource.CommodityInformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityInformationSource.CommodityInformationSourceBuilder o = (CommodityInformationSource.CommodityInformationSourceBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			merger.mergeRosetta(getRateSourcePage(), o.getRateSourcePage(), this::setRateSourcePage);
			
			merger.mergeBasic(getRateSourcePageHeading(), o.getRateSourcePageHeading(), this::setRateSourcePageHeading);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationSource _that = getType().cast(o);
		
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
			return "CommodityInformationSourceBuilder {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}
}
