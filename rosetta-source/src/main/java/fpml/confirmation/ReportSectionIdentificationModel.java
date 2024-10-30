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
import fpml.confirmation.ReportSectionIdentification;
import fpml.confirmation.ReportSectionIdentificationModel;
import fpml.confirmation.ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder;
import fpml.confirmation.ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilderImpl;
import fpml.confirmation.ReportSectionIdentificationModel.ReportSectionIdentificationModelImpl;
import fpml.confirmation.meta.ReportSectionIdentificationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows a chunck of a report to be included in a request retransmission message.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReportSectionIdentificationModel", builder=ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReportSectionIdentificationModel extends RosettaModelObject {

	ReportSectionIdentificationModelMeta metaData = new ReportSectionIdentificationModelMeta();

	/*********************** Getter Methods  ***********************/
	ReportSectionIdentification getReportIdentification();

	/*********************** Build Methods  ***********************/
	ReportSectionIdentificationModel build();
	
	ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder toBuilder();
	
	static ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder builder() {
		return new ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportSectionIdentificationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportSectionIdentificationModel> getType() {
		return ReportSectionIdentificationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportIdentification"), processor, ReportSectionIdentification.class, getReportIdentification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportSectionIdentificationModelBuilder extends ReportSectionIdentificationModel, RosettaModelObjectBuilder {
		ReportSectionIdentification.ReportSectionIdentificationBuilder getOrCreateReportIdentification();
		ReportSectionIdentification.ReportSectionIdentificationBuilder getReportIdentification();
		ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder setReportIdentification(ReportSectionIdentification reportIdentification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportIdentification"), processor, ReportSectionIdentification.ReportSectionIdentificationBuilder.class, getReportIdentification());
		}
		

		ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder prune();
	}

	/*********************** Immutable Implementation of ReportSectionIdentificationModel  ***********************/
	class ReportSectionIdentificationModelImpl implements ReportSectionIdentificationModel {
		private final ReportSectionIdentification reportIdentification;
		
		protected ReportSectionIdentificationModelImpl(ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder builder) {
			this.reportIdentification = ofNullable(builder.getReportIdentification()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		public ReportSectionIdentification getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		public ReportSectionIdentificationModel build() {
			return this;
		}
		
		@Override
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder toBuilder() {
			ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder builder) {
			ofNullable(getReportIdentification()).ifPresent(builder::setReportIdentification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentificationModel {" +
				"reportIdentification=" + this.reportIdentification +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportSectionIdentificationModel  ***********************/
	class ReportSectionIdentificationModelBuilderImpl implements ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder {
	
		protected ReportSectionIdentification.ReportSectionIdentificationBuilder reportIdentification;
	
		public ReportSectionIdentificationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reportIdentification")
		public ReportSectionIdentification.ReportSectionIdentificationBuilder getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder getOrCreateReportIdentification() {
			ReportSectionIdentification.ReportSectionIdentificationBuilder result;
			if (reportIdentification!=null) {
				result = reportIdentification;
			}
			else {
				result = reportIdentification = ReportSectionIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder setReportIdentification(ReportSectionIdentification reportIdentification) {
			this.reportIdentification = reportIdentification==null?null:reportIdentification.toBuilder();
			return this;
		}
		
		@Override
		public ReportSectionIdentificationModel build() {
			return new ReportSectionIdentificationModel.ReportSectionIdentificationModelImpl(this);
		}
		
		@Override
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder prune() {
			if (reportIdentification!=null && !reportIdentification.prune().hasData()) reportIdentification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportIdentification()!=null && getReportIdentification().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder o = (ReportSectionIdentificationModel.ReportSectionIdentificationModelBuilder) other;
			
			merger.mergeRosetta(getReportIdentification(), o.getReportIdentification(), this::setReportIdentification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentificationModelBuilder {" +
				"reportIdentification=" + this.reportIdentification +
			'}';
		}
	}
}
