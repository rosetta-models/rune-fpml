package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.validation.EquityUnderlyerProvisionsModelTypeFormatValidator;
import fpml.confirmation.validation.EquityUnderlyerProvisionsModelValidator;
import fpml.confirmation.validation.exists.EquityUnderlyerProvisionsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityUnderlyerProvisionsModel.class)
public class EquityUnderlyerProvisionsModelMeta implements RosettaMetaData<EquityUnderlyerProvisionsModel> {

	@Override
	public List<Validator<? super EquityUnderlyerProvisionsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityUnderlyerProvisionsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityUnderlyerProvisionsModel> validator() {
		return new EquityUnderlyerProvisionsModelValidator();
	}

	@Override
	public Validator<? super EquityUnderlyerProvisionsModel> typeFormatValidator() {
		return new EquityUnderlyerProvisionsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityUnderlyerProvisionsModel, Set<String>> onlyExistsValidator() {
		return new EquityUnderlyerProvisionsModelOnlyExistsValidator();
	}
}
