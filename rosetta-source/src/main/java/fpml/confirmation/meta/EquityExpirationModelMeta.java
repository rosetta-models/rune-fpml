package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.validation.EquityExpirationModelTypeFormatValidator;
import fpml.confirmation.validation.EquityExpirationModelValidator;
import fpml.confirmation.validation.exists.EquityExpirationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityExpirationModel.class)
public class EquityExpirationModelMeta implements RosettaMetaData<EquityExpirationModel> {

	@Override
	public List<Validator<? super EquityExpirationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityExpirationModel>create(fpml.confirmation.validation.datarule.EquityExpirationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityExpirationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityExpirationModel> validator() {
		return new EquityExpirationModelValidator();
	}

	@Override
	public Validator<? super EquityExpirationModel> typeFormatValidator() {
		return new EquityExpirationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityExpirationModel, Set<String>> onlyExistsValidator() {
		return new EquityExpirationModelOnlyExistsValidator();
	}
}
