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
import fpml.confirmation.AbsoluteTolerance;
import fpml.confirmation.OilDelivery;
import fpml.confirmation.OilDelivery.OilDeliveryBuilder;
import fpml.confirmation.OilDelivery.OilDeliveryBuilderImpl;
import fpml.confirmation.OilDelivery.OilDeliveryImpl;
import fpml.confirmation.OilPipelineDelivery;
import fpml.confirmation.OilTransferDelivery;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PercentageTolerance;
import fpml.confirmation.meta.OilDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery conditions for an oil product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OilDelivery", builder=OilDelivery.OilDeliveryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OilDelivery extends RosettaModelObject {

	OilDeliveryMeta metaData = new OilDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specified the delivery conditions where the oil product is to be delivered by pipeline.
	 */
	OilPipelineDelivery getPipeline();
	/**
	 * Specified the delivery conditions where the oil product is to be delivered by title transfer.
	 */
	OilTransferDelivery getTransfer();
	/**
	 * Specifies which party is the Importer of Record for the purposes of paying customs duties and applicable taxes or costs related to the import of the oil product.
	 */
	PartyReference getImporterOfRecord();
	/**
	 * Specifies the allowable quantity tolerance as an absolute quantity.
	 */
	AbsoluteTolerance getAbsoluteTolerance();
	/**
	 * Specifies the allowable quantity tolerance as a percentage of the quantity.
	 */
	PercentageTolerance getPercentageTolerance();

	/*********************** Build Methods  ***********************/
	OilDelivery build();
	
	OilDelivery.OilDeliveryBuilder toBuilder();
	
	static OilDelivery.OilDeliveryBuilder builder() {
		return new OilDelivery.OilDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OilDelivery> getType() {
		return OilDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pipeline"), processor, OilPipelineDelivery.class, getPipeline());
		processRosetta(path.newSubPath("transfer"), processor, OilTransferDelivery.class, getTransfer());
		processRosetta(path.newSubPath("importerOfRecord"), processor, PartyReference.class, getImporterOfRecord());
		processRosetta(path.newSubPath("absoluteTolerance"), processor, AbsoluteTolerance.class, getAbsoluteTolerance());
		processRosetta(path.newSubPath("percentageTolerance"), processor, PercentageTolerance.class, getPercentageTolerance());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilDeliveryBuilder extends OilDelivery, RosettaModelObjectBuilder {
		OilPipelineDelivery.OilPipelineDeliveryBuilder getOrCreatePipeline();
		OilPipelineDelivery.OilPipelineDeliveryBuilder getPipeline();
		OilTransferDelivery.OilTransferDeliveryBuilder getOrCreateTransfer();
		OilTransferDelivery.OilTransferDeliveryBuilder getTransfer();
		PartyReference.PartyReferenceBuilder getOrCreateImporterOfRecord();
		PartyReference.PartyReferenceBuilder getImporterOfRecord();
		AbsoluteTolerance.AbsoluteToleranceBuilder getOrCreateAbsoluteTolerance();
		AbsoluteTolerance.AbsoluteToleranceBuilder getAbsoluteTolerance();
		PercentageTolerance.PercentageToleranceBuilder getOrCreatePercentageTolerance();
		PercentageTolerance.PercentageToleranceBuilder getPercentageTolerance();
		OilDelivery.OilDeliveryBuilder setPipeline(OilPipelineDelivery pipeline);
		OilDelivery.OilDeliveryBuilder setTransfer(OilTransferDelivery transfer);
		OilDelivery.OilDeliveryBuilder setImporterOfRecord(PartyReference importerOfRecord);
		OilDelivery.OilDeliveryBuilder setAbsoluteTolerance(AbsoluteTolerance absoluteTolerance);
		OilDelivery.OilDeliveryBuilder setPercentageTolerance(PercentageTolerance percentageTolerance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pipeline"), processor, OilPipelineDelivery.OilPipelineDeliveryBuilder.class, getPipeline());
			processRosetta(path.newSubPath("transfer"), processor, OilTransferDelivery.OilTransferDeliveryBuilder.class, getTransfer());
			processRosetta(path.newSubPath("importerOfRecord"), processor, PartyReference.PartyReferenceBuilder.class, getImporterOfRecord());
			processRosetta(path.newSubPath("absoluteTolerance"), processor, AbsoluteTolerance.AbsoluteToleranceBuilder.class, getAbsoluteTolerance());
			processRosetta(path.newSubPath("percentageTolerance"), processor, PercentageTolerance.PercentageToleranceBuilder.class, getPercentageTolerance());
		}
		

		OilDelivery.OilDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of OilDelivery  ***********************/
	class OilDeliveryImpl implements OilDelivery {
		private final OilPipelineDelivery pipeline;
		private final OilTransferDelivery transfer;
		private final PartyReference importerOfRecord;
		private final AbsoluteTolerance absoluteTolerance;
		private final PercentageTolerance percentageTolerance;
		
		protected OilDeliveryImpl(OilDelivery.OilDeliveryBuilder builder) {
			this.pipeline = ofNullable(builder.getPipeline()).map(f->f.build()).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).map(f->f.build()).orElse(null);
			this.importerOfRecord = ofNullable(builder.getImporterOfRecord()).map(f->f.build()).orElse(null);
			this.absoluteTolerance = ofNullable(builder.getAbsoluteTolerance()).map(f->f.build()).orElse(null);
			this.percentageTolerance = ofNullable(builder.getPercentageTolerance()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pipeline")
		public OilPipelineDelivery getPipeline() {
			return pipeline;
		}
		
		@Override
		@RosettaAttribute("transfer")
		public OilTransferDelivery getTransfer() {
			return transfer;
		}
		
		@Override
		@RosettaAttribute("importerOfRecord")
		public PartyReference getImporterOfRecord() {
			return importerOfRecord;
		}
		
		@Override
		@RosettaAttribute("absoluteTolerance")
		public AbsoluteTolerance getAbsoluteTolerance() {
			return absoluteTolerance;
		}
		
		@Override
		@RosettaAttribute("percentageTolerance")
		public PercentageTolerance getPercentageTolerance() {
			return percentageTolerance;
		}
		
		@Override
		public OilDelivery build() {
			return this;
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder toBuilder() {
			OilDelivery.OilDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilDelivery.OilDeliveryBuilder builder) {
			ofNullable(getPipeline()).ifPresent(builder::setPipeline);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
			ofNullable(getImporterOfRecord()).ifPresent(builder::setImporterOfRecord);
			ofNullable(getAbsoluteTolerance()).ifPresent(builder::setAbsoluteTolerance);
			ofNullable(getPercentageTolerance()).ifPresent(builder::setPercentageTolerance);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipeline, _that.getPipeline())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(importerOfRecord, _that.getImporterOfRecord())) return false;
			if (!Objects.equals(absoluteTolerance, _that.getAbsoluteTolerance())) return false;
			if (!Objects.equals(percentageTolerance, _that.getPercentageTolerance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipeline != null ? pipeline.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (importerOfRecord != null ? importerOfRecord.hashCode() : 0);
			_result = 31 * _result + (absoluteTolerance != null ? absoluteTolerance.hashCode() : 0);
			_result = 31 * _result + (percentageTolerance != null ? percentageTolerance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilDelivery {" +
				"pipeline=" + this.pipeline + ", " +
				"transfer=" + this.transfer + ", " +
				"importerOfRecord=" + this.importerOfRecord + ", " +
				"absoluteTolerance=" + this.absoluteTolerance + ", " +
				"percentageTolerance=" + this.percentageTolerance +
			'}';
		}
	}

	/*********************** Builder Implementation of OilDelivery  ***********************/
	class OilDeliveryBuilderImpl implements OilDelivery.OilDeliveryBuilder {
	
		protected OilPipelineDelivery.OilPipelineDeliveryBuilder pipeline;
		protected OilTransferDelivery.OilTransferDeliveryBuilder transfer;
		protected PartyReference.PartyReferenceBuilder importerOfRecord;
		protected AbsoluteTolerance.AbsoluteToleranceBuilder absoluteTolerance;
		protected PercentageTolerance.PercentageToleranceBuilder percentageTolerance;
	
		public OilDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pipeline")
		public OilPipelineDelivery.OilPipelineDeliveryBuilder getPipeline() {
			return pipeline;
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder getOrCreatePipeline() {
			OilPipelineDelivery.OilPipelineDeliveryBuilder result;
			if (pipeline!=null) {
				result = pipeline;
			}
			else {
				result = pipeline = OilPipelineDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transfer")
		public OilTransferDelivery.OilTransferDeliveryBuilder getTransfer() {
			return transfer;
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder getOrCreateTransfer() {
			OilTransferDelivery.OilTransferDeliveryBuilder result;
			if (transfer!=null) {
				result = transfer;
			}
			else {
				result = transfer = OilTransferDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("importerOfRecord")
		public PartyReference.PartyReferenceBuilder getImporterOfRecord() {
			return importerOfRecord;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateImporterOfRecord() {
			PartyReference.PartyReferenceBuilder result;
			if (importerOfRecord!=null) {
				result = importerOfRecord;
			}
			else {
				result = importerOfRecord = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("absoluteTolerance")
		public AbsoluteTolerance.AbsoluteToleranceBuilder getAbsoluteTolerance() {
			return absoluteTolerance;
		}
		
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder getOrCreateAbsoluteTolerance() {
			AbsoluteTolerance.AbsoluteToleranceBuilder result;
			if (absoluteTolerance!=null) {
				result = absoluteTolerance;
			}
			else {
				result = absoluteTolerance = AbsoluteTolerance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageTolerance")
		public PercentageTolerance.PercentageToleranceBuilder getPercentageTolerance() {
			return percentageTolerance;
		}
		
		@Override
		public PercentageTolerance.PercentageToleranceBuilder getOrCreatePercentageTolerance() {
			PercentageTolerance.PercentageToleranceBuilder result;
			if (percentageTolerance!=null) {
				result = percentageTolerance;
			}
			else {
				result = percentageTolerance = PercentageTolerance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pipeline")
		public OilDelivery.OilDeliveryBuilder setPipeline(OilPipelineDelivery pipeline) {
			this.pipeline = pipeline==null?null:pipeline.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transfer")
		public OilDelivery.OilDeliveryBuilder setTransfer(OilTransferDelivery transfer) {
			this.transfer = transfer==null?null:transfer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("importerOfRecord")
		public OilDelivery.OilDeliveryBuilder setImporterOfRecord(PartyReference importerOfRecord) {
			this.importerOfRecord = importerOfRecord==null?null:importerOfRecord.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("absoluteTolerance")
		public OilDelivery.OilDeliveryBuilder setAbsoluteTolerance(AbsoluteTolerance absoluteTolerance) {
			this.absoluteTolerance = absoluteTolerance==null?null:absoluteTolerance.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("percentageTolerance")
		public OilDelivery.OilDeliveryBuilder setPercentageTolerance(PercentageTolerance percentageTolerance) {
			this.percentageTolerance = percentageTolerance==null?null:percentageTolerance.toBuilder();
			return this;
		}
		
		@Override
		public OilDelivery build() {
			return new OilDelivery.OilDeliveryImpl(this);
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilDelivery.OilDeliveryBuilder prune() {
			if (pipeline!=null && !pipeline.prune().hasData()) pipeline = null;
			if (transfer!=null && !transfer.prune().hasData()) transfer = null;
			if (importerOfRecord!=null && !importerOfRecord.prune().hasData()) importerOfRecord = null;
			if (absoluteTolerance!=null && !absoluteTolerance.prune().hasData()) absoluteTolerance = null;
			if (percentageTolerance!=null && !percentageTolerance.prune().hasData()) percentageTolerance = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPipeline()!=null && getPipeline().hasData()) return true;
			if (getTransfer()!=null && getTransfer().hasData()) return true;
			if (getImporterOfRecord()!=null && getImporterOfRecord().hasData()) return true;
			if (getAbsoluteTolerance()!=null && getAbsoluteTolerance().hasData()) return true;
			if (getPercentageTolerance()!=null && getPercentageTolerance().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilDelivery.OilDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilDelivery.OilDeliveryBuilder o = (OilDelivery.OilDeliveryBuilder) other;
			
			merger.mergeRosetta(getPipeline(), o.getPipeline(), this::setPipeline);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::setTransfer);
			merger.mergeRosetta(getImporterOfRecord(), o.getImporterOfRecord(), this::setImporterOfRecord);
			merger.mergeRosetta(getAbsoluteTolerance(), o.getAbsoluteTolerance(), this::setAbsoluteTolerance);
			merger.mergeRosetta(getPercentageTolerance(), o.getPercentageTolerance(), this::setPercentageTolerance);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipeline, _that.getPipeline())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(importerOfRecord, _that.getImporterOfRecord())) return false;
			if (!Objects.equals(absoluteTolerance, _that.getAbsoluteTolerance())) return false;
			if (!Objects.equals(percentageTolerance, _that.getPercentageTolerance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipeline != null ? pipeline.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (importerOfRecord != null ? importerOfRecord.hashCode() : 0);
			_result = 31 * _result + (absoluteTolerance != null ? absoluteTolerance.hashCode() : 0);
			_result = 31 * _result + (percentageTolerance != null ? percentageTolerance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilDeliveryBuilder {" +
				"pipeline=" + this.pipeline + ", " +
				"transfer=" + this.transfer + ", " +
				"importerOfRecord=" + this.importerOfRecord + ", " +
				"absoluteTolerance=" + this.absoluteTolerance + ", " +
				"percentageTolerance=" + this.percentageTolerance +
			'}';
		}
	}
}
