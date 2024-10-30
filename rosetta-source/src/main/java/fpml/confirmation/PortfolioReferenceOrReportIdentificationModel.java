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
import fpml.confirmation.PortfolioConstituentReferenceModel;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilderImpl;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelImpl;
import fpml.confirmation.ReportSectionIdentificationModel;
import fpml.confirmation.meta.PortfolioReferenceOrReportIdentificationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows either details of a portoflio constituent or report constituent to be provided. Typically this will be used in a request retransmission message.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PortfolioReferenceOrReportIdentificationModel", builder=PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PortfolioReferenceOrReportIdentificationModel extends RosettaModelObject {

	PortfolioReferenceOrReportIdentificationModelMeta metaData = new PortfolioReferenceOrReportIdentificationModelMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioConstituentReferenceModel getPortfolioConstituentReferenceModel();
	ReportSectionIdentificationModel getReportSectionIdentificationModel();

	/*********************** Build Methods  ***********************/
	PortfolioReferenceOrReportIdentificationModel build();
	
	PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder toBuilder();
	
	static PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder builder() {
		return new PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReferenceOrReportIdentificationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioReferenceOrReportIdentificationModel> getType() {
		return PortfolioReferenceOrReportIdentificationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioConstituentReferenceModel"), processor, PortfolioConstituentReferenceModel.class, getPortfolioConstituentReferenceModel());
		processRosetta(path.newSubPath("reportSectionIdentificationModel"), processor, ReportSectionIdentificationModel.class, getReportSectionIdentificationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReferenceOrReportIdentificationModelBuilder extends PortfolioReferenceOrReportIdentificationModel, RosettaModelObjectBuilder {
		PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder getOrCreatePortfolioConstituentReferenceModel();
		PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder getPortfolioConstituentReferenceModel();
		ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder getOrCreateReportSectionIdentificationModel();
		ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder getReportSectionIdentificationModel();
		PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder setPortfolioConstituentReferenceModel(PortfolioConstituentReferenceModel portfolioConstituentReferenceModel);
		PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder setReportSectionIdentificationModel(ReportSectionIdentificationModel reportSectionIdentificationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioConstituentReferenceModel"), processor, PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder.class, getPortfolioConstituentReferenceModel());
			processRosetta(path.newSubPath("reportSectionIdentificationModel"), processor, ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder.class, getReportSectionIdentificationModel());
		}
		

		PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReferenceOrReportIdentificationModel  ***********************/
	class PortfolioReferenceOrReportIdentificationModelImpl implements PortfolioReferenceOrReportIdentificationModel {
		private final PortfolioConstituentReferenceModel portfolioConstituentReferenceModel;
		private final ReportSectionIdentificationModel reportSectionIdentificationModel;
		
		protected PortfolioReferenceOrReportIdentificationModelImpl(PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder builder) {
			this.portfolioConstituentReferenceModel = ofNullable(builder.getPortfolioConstituentReferenceModel()).map(f->f.build()).orElse(null);
			this.reportSectionIdentificationModel = ofNullable(builder.getReportSectionIdentificationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioConstituentReferenceModel")
		public PortfolioConstituentReferenceModel getPortfolioConstituentReferenceModel() {
			return portfolioConstituentReferenceModel;
		}
		
		@Override
		@RosettaAttribute("reportSectionIdentificationModel")
		public ReportSectionIdentificationModel getReportSectionIdentificationModel() {
			return reportSectionIdentificationModel;
		}
		
		@Override
		public PortfolioReferenceOrReportIdentificationModel build() {
			return this;
		}
		
		@Override
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder toBuilder() {
			PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder builder) {
			ofNullable(getPortfolioConstituentReferenceModel()).ifPresent(builder::setPortfolioConstituentReferenceModel);
			ofNullable(getReportSectionIdentificationModel()).ifPresent(builder::setReportSectionIdentificationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceOrReportIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioConstituentReferenceModel, _that.getPortfolioConstituentReferenceModel())) return false;
			if (!Objects.equals(reportSectionIdentificationModel, _that.getReportSectionIdentificationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioConstituentReferenceModel != null ? portfolioConstituentReferenceModel.hashCode() : 0);
			_result = 31 * _result + (reportSectionIdentificationModel != null ? reportSectionIdentificationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceOrReportIdentificationModel {" +
				"portfolioConstituentReferenceModel=" + this.portfolioConstituentReferenceModel + ", " +
				"reportSectionIdentificationModel=" + this.reportSectionIdentificationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioReferenceOrReportIdentificationModel  ***********************/
	class PortfolioReferenceOrReportIdentificationModelBuilderImpl implements PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder {
	
		protected PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder portfolioConstituentReferenceModel;
		protected ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder reportSectionIdentificationModel;
	
		public PortfolioReferenceOrReportIdentificationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioConstituentReferenceModel")
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder getPortfolioConstituentReferenceModel() {
			return portfolioConstituentReferenceModel;
		}
		
		@Override
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder getOrCreatePortfolioConstituentReferenceModel() {
			PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder result;
			if (portfolioConstituentReferenceModel!=null) {
				result = portfolioConstituentReferenceModel;
			}
			else {
				result = portfolioConstituentReferenceModel = PortfolioConstituentReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportSectionIdentificationModel")
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder getReportSectionIdentificationModel() {
			return reportSectionIdentificationModel;
		}
		
		@Override
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder getOrCreateReportSectionIdentificationModel() {
			ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder result;
			if (reportSectionIdentificationModel!=null) {
				result = reportSectionIdentificationModel;
			}
			else {
				result = reportSectionIdentificationModel = ReportSectionIdentificationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioConstituentReferenceModel")
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder setPortfolioConstituentReferenceModel(PortfolioConstituentReferenceModel portfolioConstituentReferenceModel) {
			this.portfolioConstituentReferenceModel = portfolioConstituentReferenceModel==null?null:portfolioConstituentReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reportSectionIdentificationModel")
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder setReportSectionIdentificationModel(ReportSectionIdentificationModel reportSectionIdentificationModel) {
			this.reportSectionIdentificationModel = reportSectionIdentificationModel==null?null:reportSectionIdentificationModel.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioReferenceOrReportIdentificationModel build() {
			return new PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelImpl(this);
		}
		
		@Override
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder prune() {
			if (portfolioConstituentReferenceModel!=null && !portfolioConstituentReferenceModel.prune().hasData()) portfolioConstituentReferenceModel = null;
			if (reportSectionIdentificationModel!=null && !reportSectionIdentificationModel.prune().hasData()) reportSectionIdentificationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPortfolioConstituentReferenceModel()!=null && getPortfolioConstituentReferenceModel().hasData()) return true;
			if (getReportSectionIdentificationModel()!=null && getReportSectionIdentificationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder o = (PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder) other;
			
			merger.mergeRosetta(getPortfolioConstituentReferenceModel(), o.getPortfolioConstituentReferenceModel(), this::setPortfolioConstituentReferenceModel);
			merger.mergeRosetta(getReportSectionIdentificationModel(), o.getReportSectionIdentificationModel(), this::setReportSectionIdentificationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceOrReportIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioConstituentReferenceModel, _that.getPortfolioConstituentReferenceModel())) return false;
			if (!Objects.equals(reportSectionIdentificationModel, _that.getReportSectionIdentificationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioConstituentReferenceModel != null ? portfolioConstituentReferenceModel.hashCode() : 0);
			_result = 31 * _result + (reportSectionIdentificationModel != null ? reportSectionIdentificationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceOrReportIdentificationModelBuilder {" +
				"portfolioConstituentReferenceModel=" + this.portfolioConstituentReferenceModel + ", " +
				"reportSectionIdentificationModel=" + this.reportSectionIdentificationModel +
			'}';
		}
	}
}
