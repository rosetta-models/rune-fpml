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
import fpml.confirmation.ReportingLevel;
import fpml.confirmation.TradeSummary;
import fpml.confirmation.TradeSummary.TradeSummaryBuilder;
import fpml.confirmation.TradeSummary.TradeSummaryBuilderImpl;
import fpml.confirmation.TradeSummary.TradeSummaryImpl;
import fpml.confirmation.meta.TradeSummaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Summary information about the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeSummary", builder=TradeSummary.TradeSummaryBuilderImpl.class, version="${project.version}")
public interface TradeSummary extends RosettaModelObject {

	TradeSummaryMeta metaData = new TradeSummaryMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getIsPackageTrade();
	Boolean getIsPrimeBrokerTrade();
	ReportingLevel getReportingLevel();

	/*********************** Build Methods  ***********************/
	TradeSummary build();
	
	TradeSummary.TradeSummaryBuilder toBuilder();
	
	static TradeSummary.TradeSummaryBuilder builder() {
		return new TradeSummary.TradeSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeSummary> getType() {
		return TradeSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isPackageTrade"), Boolean.class, getIsPackageTrade(), this);
		processor.processBasic(path.newSubPath("isPrimeBrokerTrade"), Boolean.class, getIsPrimeBrokerTrade(), this);
		processRosetta(path.newSubPath("reportingLevel"), processor, ReportingLevel.class, getReportingLevel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeSummaryBuilder extends TradeSummary, RosettaModelObjectBuilder {
		ReportingLevel.ReportingLevelBuilder getOrCreateReportingLevel();
		ReportingLevel.ReportingLevelBuilder getReportingLevel();
		TradeSummary.TradeSummaryBuilder setIsPackageTrade(Boolean isPackageTrade);
		TradeSummary.TradeSummaryBuilder setIsPrimeBrokerTrade(Boolean isPrimeBrokerTrade);
		TradeSummary.TradeSummaryBuilder setReportingLevel(ReportingLevel reportingLevel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isPackageTrade"), Boolean.class, getIsPackageTrade(), this);
			processor.processBasic(path.newSubPath("isPrimeBrokerTrade"), Boolean.class, getIsPrimeBrokerTrade(), this);
			processRosetta(path.newSubPath("reportingLevel"), processor, ReportingLevel.ReportingLevelBuilder.class, getReportingLevel());
		}
		

		TradeSummary.TradeSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of TradeSummary  ***********************/
	class TradeSummaryImpl implements TradeSummary {
		private final Boolean isPackageTrade;
		private final Boolean isPrimeBrokerTrade;
		private final ReportingLevel reportingLevel;
		
		protected TradeSummaryImpl(TradeSummary.TradeSummaryBuilder builder) {
			this.isPackageTrade = builder.getIsPackageTrade();
			this.isPrimeBrokerTrade = builder.getIsPrimeBrokerTrade();
			this.reportingLevel = ofNullable(builder.getReportingLevel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isPackageTrade")
		public Boolean getIsPackageTrade() {
			return isPackageTrade;
		}
		
		@Override
		@RosettaAttribute("isPrimeBrokerTrade")
		public Boolean getIsPrimeBrokerTrade() {
			return isPrimeBrokerTrade;
		}
		
		@Override
		@RosettaAttribute("reportingLevel")
		public ReportingLevel getReportingLevel() {
			return reportingLevel;
		}
		
		@Override
		public TradeSummary build() {
			return this;
		}
		
		@Override
		public TradeSummary.TradeSummaryBuilder toBuilder() {
			TradeSummary.TradeSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeSummary.TradeSummaryBuilder builder) {
			ofNullable(getIsPackageTrade()).ifPresent(builder::setIsPackageTrade);
			ofNullable(getIsPrimeBrokerTrade()).ifPresent(builder::setIsPrimeBrokerTrade);
			ofNullable(getReportingLevel()).ifPresent(builder::setReportingLevel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(isPackageTrade, _that.getIsPackageTrade())) return false;
			if (!Objects.equals(isPrimeBrokerTrade, _that.getIsPrimeBrokerTrade())) return false;
			if (!Objects.equals(reportingLevel, _that.getReportingLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isPackageTrade != null ? isPackageTrade.hashCode() : 0);
			_result = 31 * _result + (isPrimeBrokerTrade != null ? isPrimeBrokerTrade.hashCode() : 0);
			_result = 31 * _result + (reportingLevel != null ? reportingLevel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeSummary {" +
				"isPackageTrade=" + this.isPackageTrade + ", " +
				"isPrimeBrokerTrade=" + this.isPrimeBrokerTrade + ", " +
				"reportingLevel=" + this.reportingLevel +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeSummary  ***********************/
	class TradeSummaryBuilderImpl implements TradeSummary.TradeSummaryBuilder {
	
		protected Boolean isPackageTrade;
		protected Boolean isPrimeBrokerTrade;
		protected ReportingLevel.ReportingLevelBuilder reportingLevel;
	
		public TradeSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("isPackageTrade")
		public Boolean getIsPackageTrade() {
			return isPackageTrade;
		}
		
		@Override
		@RosettaAttribute("isPrimeBrokerTrade")
		public Boolean getIsPrimeBrokerTrade() {
			return isPrimeBrokerTrade;
		}
		
		@Override
		@RosettaAttribute("reportingLevel")
		public ReportingLevel.ReportingLevelBuilder getReportingLevel() {
			return reportingLevel;
		}
		
		@Override
		public ReportingLevel.ReportingLevelBuilder getOrCreateReportingLevel() {
			ReportingLevel.ReportingLevelBuilder result;
			if (reportingLevel!=null) {
				result = reportingLevel;
			}
			else {
				result = reportingLevel = ReportingLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isPackageTrade")
		public TradeSummary.TradeSummaryBuilder setIsPackageTrade(Boolean isPackageTrade) {
			this.isPackageTrade = isPackageTrade==null?null:isPackageTrade;
			return this;
		}
		@Override
		@RosettaAttribute("isPrimeBrokerTrade")
		public TradeSummary.TradeSummaryBuilder setIsPrimeBrokerTrade(Boolean isPrimeBrokerTrade) {
			this.isPrimeBrokerTrade = isPrimeBrokerTrade==null?null:isPrimeBrokerTrade;
			return this;
		}
		@Override
		@RosettaAttribute("reportingLevel")
		public TradeSummary.TradeSummaryBuilder setReportingLevel(ReportingLevel reportingLevel) {
			this.reportingLevel = reportingLevel==null?null:reportingLevel.toBuilder();
			return this;
		}
		
		@Override
		public TradeSummary build() {
			return new TradeSummary.TradeSummaryImpl(this);
		}
		
		@Override
		public TradeSummary.TradeSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeSummary.TradeSummaryBuilder prune() {
			if (reportingLevel!=null && !reportingLevel.prune().hasData()) reportingLevel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsPackageTrade()!=null) return true;
			if (getIsPrimeBrokerTrade()!=null) return true;
			if (getReportingLevel()!=null && getReportingLevel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeSummary.TradeSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeSummary.TradeSummaryBuilder o = (TradeSummary.TradeSummaryBuilder) other;
			
			merger.mergeRosetta(getReportingLevel(), o.getReportingLevel(), this::setReportingLevel);
			
			merger.mergeBasic(getIsPackageTrade(), o.getIsPackageTrade(), this::setIsPackageTrade);
			merger.mergeBasic(getIsPrimeBrokerTrade(), o.getIsPrimeBrokerTrade(), this::setIsPrimeBrokerTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(isPackageTrade, _that.getIsPackageTrade())) return false;
			if (!Objects.equals(isPrimeBrokerTrade, _that.getIsPrimeBrokerTrade())) return false;
			if (!Objects.equals(reportingLevel, _that.getReportingLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isPackageTrade != null ? isPackageTrade.hashCode() : 0);
			_result = 31 * _result + (isPrimeBrokerTrade != null ? isPrimeBrokerTrade.hashCode() : 0);
			_result = 31 * _result + (reportingLevel != null ? reportingLevel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeSummaryBuilder {" +
				"isPackageTrade=" + this.isPackageTrade + ", " +
				"isPrimeBrokerTrade=" + this.isPrimeBrokerTrade + ", " +
				"reportingLevel=" + this.reportingLevel +
			'}';
		}
	}
}
