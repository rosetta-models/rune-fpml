package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel;
import fpml.confirmation.validation.PortfolioReferenceOrReportIdentificationModelTypeFormatValidator;
import fpml.confirmation.validation.PortfolioReferenceOrReportIdentificationModelValidator;
import fpml.confirmation.validation.exists.PortfolioReferenceOrReportIdentificationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PortfolioReferenceOrReportIdentificationModel.class)
public class PortfolioReferenceOrReportIdentificationModelMeta implements RosettaMetaData<PortfolioReferenceOrReportIdentificationModel> {

	@Override
	public List<Validator<? super PortfolioReferenceOrReportIdentificationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PortfolioReferenceOrReportIdentificationModel>create(fpml.confirmation.validation.datarule.PortfolioReferenceOrReportIdentificationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PortfolioReferenceOrReportIdentificationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioReferenceOrReportIdentificationModel> validator() {
		return new PortfolioReferenceOrReportIdentificationModelValidator();
	}

	@Override
	public Validator<? super PortfolioReferenceOrReportIdentificationModel> typeFormatValidator() {
		return new PortfolioReferenceOrReportIdentificationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReferenceOrReportIdentificationModel, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceOrReportIdentificationModelOnlyExistsValidator();
	}
}
